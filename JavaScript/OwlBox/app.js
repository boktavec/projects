const { json } = require("express");
const express = require("express");
const app = express(); //Declare express server
const http = require("http").Server(app);
const cors = require("cors");
const io = require("socket.io")(http);
const dgram = require("dgram");
const JSONSocket = require("udp-json");
const pNp = require("point-in-polygon");
const utmObj = require("utm-latlng");

const utm = new utmObj();

app.set("view engine", "ejs"); //Set view to ejs
app.use(express.static("public")); //declare file locations
app.use(express.urlencoded({ extended: true }));
app.use(express.json()); //Use JSON within express
app.use(cors(corsOptions)); //Bypass webpage security

//---- Create JSON UDP Socket----//
const client = dgram.createSocket("udp4");
const clientSocket = new JSONSocket(client);

const ADDRESS = "";
const PORT = 50001;
let select = "";

//UTM coordinates -> [UTM E, UTM N, UTM Zone] ~ UTM Zone = 16S

//---- PTC UTM ----//
const ptc = [
  [756527.83, 3762241.49],
  [758106.49, 3761375.46],
  [755893.84, 3759871.43],
  [755458.63, 3760072.04],
];

//---- KSAW UTM ----//
const ksaw = [
  [728335.61, 3758509.79],
  [729654.61, 3758567.18],
  [728245.91, 3757694.14],
  [728812.65, 3757381.52],
  [729923.89, 3757903.05],
];

client.bind({
  port: PORT,
  address: ADDRESS,
});

const corsOptions = {
  origin: "http://localhost:3000/",
  credentials: true, //access-control-allow-credentials:true
  optionSuccessStatus: 200,
};

//----- FILTER -----//
const locFilter = (data) => {
  let utmZ = utm.convertLatLngToUtm(data.Lat, data.Lon, 0);
  if (pNp([utmZ.Easting, utmZ.Northing], ksaw)) {
    return 0;
  } else if (pNp([utmZ.Easting, utmZ.Northing], ptc)) {
    return 1;
  } 
};

io.on("connection", (socket) => {
  console.log("A user is connected");

  socket.on("selKSU", () => {
    socket.leave("room-ptc");
    socket.join("room-kennesaw");
    console.log("client selected KSU location");
    select = "kennesaw";
  });

  socket.on("selPTC", () => {
    socket.leave("room-kennesaw");
    socket.join("room-ptc");
    console.log("client selected PTC location");
    select = "ptc";
  });
});

//Filter and send data to a room
clientSocket.on("message-complete", (data) => {
  if (select === "kennesaw" && locFilter(data) === 0) {
    //send kennesaw data
    io.to("room-kennesaw").emit("data", data);
  } else if (select === "ptc" && locFilter(data) === 1) {
    //send ptc data
    io.to("room-ptc").emit("data", data);
  }
});

//render index page on path '/'
app.get("/", (req, res) => {
  res.render("index");
});

//listen for/access server on localhost port 3000
http.listen(3000, () => {
  console.log("Server is running");
});

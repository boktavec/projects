// Create and initiate Express server
const { json } = require("express");
const express = require("express");
const app = express(); //Declare express server

const http = require("http").Server(app); // Create and initiate http server incoporating Express
const cors = require("cors"); //Allows us to bypass necessary credentials
const io = require("socket.io")(http); //Websockets
const dgram = require("dgram"); //UDP sockets
const JSONSocket = require("udp-json"); //JSON socket

//For filter -> UTM converter and location bubble
const pNp = require("point-in-polygon");
const utmObj = require("utm-latlng");

//Initiate UTM converter and UDP & JSON socket
const utm = new utmObj();
const client = dgram.createSocket("udp4");
const clientSocket = new JSONSocket(client);

//Socket location
const ADDRESS = "";
const PORT = "";

let select = ""; //Location selection

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

// Bind socket location
client.bind({
  port: PORT,
  address: ADDRESS,
});

//Web credential bypass
const corsOptions = {
  origin: "http://localhost:3000/",
  credentials: true, //access-control-allow-credentials:true
  optionSuccessStatus: 200,
};

//Filters data to through location and if certain location is selected it will send the respective data to the client
const locFilter = (data) => {
  let utmZ = utm.convertLatLngToUtm(data.Lat, data.Lon, 0);
  if (pNp([utmZ.Easting, utmZ.Northing], ksaw)) {
    return 0;
  } else if (pNp([utmZ.Easting, utmZ.Northing], ptc)) {
    return 1;
  }
};

//Express settings
app.set("view engine", "ejs"); //Set view to ejs
app.use(express.static("public")); //declare file locations
app.use(express.urlencoded({ extended: true }));
app.use(express.json()); //Use JSON within express
app.use(cors(corsOptions)); //Bypass webpage security

//Creates Websocket and performs necessary tasks
io.on("connection", (socket) => {
  console.log("A user is connected");

  //Joins KSAW socket room
  socket.on("selKSU", () => {
    socket.leave("room-ptc");
    socket.join("room-kennesaw");
    console.log("client selected KSU location");
    select = "kennesaw";
  });

  //Joins PTC socket room
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

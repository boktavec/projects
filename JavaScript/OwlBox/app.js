// Create and initiate Express server
const { json } = require("express");
const express = require("express");
const app = express(); //Declare express server

const http = require("http").Server(app); // Create and initiate http server incoporating Express
const cors = require("cors"); //Allows us to bypass necessary credentials
const io = require("socket.io")(http); //Websockets
const dgram = require("dgram"); //UDP sockets

//For filter -> UTM converter and location bubble
const pNp = require("point-in-polygon");
const utmObj = require("utm-latlng");

//Initiate UTM converter and UDP & JSON socket
const utm = new utmObj();
const client = dgram.createSocket("udp4");

//Initiate Array Object to CSV file
const json2csv = require("json2csv");

let select = ""; //Location selection
let recStatus = ""; //Status of recorder
let recording = []; //Holds the recordede data
let dataCSV; //CSV file to be downloaded

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

  //Start recording, stop recording and save recording
  socket.on("record", () => {
    console.log("start recording");
    recStatus = "rec";
  });

  socket.on("stop", () => {
    console.log("stop");
    recStatus = "stop";
  });

  socket.on("save", () => {
    recStatus = "stop";
    dataCSV = json2csv.parse(recording);
  });
});

//Filter and send data to a room
client.on("message-complete", (data) => {
  //Convert data to string and JSON parse it so it is usable
  let x = JSON.parse(String.fromCharCode.apply(String, data));
  console.log(x);

  if (select === "kennesaw" && locFilter(x) === 0) {
    //send kennesaw data
    io.to("room-kennesaw").emit("data", x);
    //Record and Save drive
    while (recStatus === "rec") {
      recording.push(x);
    }
  } else if (select === "ptc" && locFilter(x) === 1) {
    //send ptc data
    io.to("room-ptc").emit("data", x);
    //Record and Save drive
    while (recStatus === "rec") {
      recording.push(x);
    }
  }
});

//render index page on path '/'
app.get("/", (req, res) => {
  res.render("index");
});

//Download page to download the csv file
app.get("/download", (req, res) => {
  let date = Date.now();
  res.setHeader(
    "Content-disposition",
    "attachment; filename=" + date + "-owlbox.csv"
  );
  res.set("Content-Type", "text/csv");
  res.status(200).send(dataCSV);
  recording.length = 0;
});

//listen for/access server on localhost port 3000
http.listen(3000, () => {
  console.log("Server is running");
});

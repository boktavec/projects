let map;
const image = "https://img.icons8.com/fluent/48/000000/car-top-view.png"; //Marker image

// Location selection
let clickMarker;
let clickLoc;

// Store created markers in this object
let markerStore = {};

//Create the socket connection with the server
const socket = io();

//Initiate all the necessary locations
const home = { lat: xx.xxxxxx, lng: xx.xxxxxx }; //Initial coordinates to center the map and marker
const ksaw = { lat: xx.xxxxxx, lng: xx.xxxxxx }; //Coordinates for Marietta campus of KSAW
const ptc = { lat: xx.xxxxxx, lng: xx.xxxxxx }; //Coordinates for city hall Peachtree Corners

// Creates link to box depending on location and if the container link already exists
let boxCar = (id) => {
  if (clickLoc === "kennesaw") {
    $("#ksaw").append(
      "<div class = 'owlbox' id ='" + id + "'> <span> " + id + "</span> </div>"
    );
  } else if (clickLoc === "ptc") {
    $("#ptc").append(
      "<div class = 'owlbox' id ='" + id + "'> <span>" + id + "</span> </div>"
    );
  }
};

// Changes the table of box data to the updated data coming in through the socket
let boxData = (x) => {
  document.getElementById("obID").innerHTML = x.owlboxID;
  document.getElementById("msgCnt").innerHTML = x.msgCnt;
  document.getElementById("tempID").innerHTML = x.tempid;
  document.getElementById("time").innerHTML = x.time;
  document.getElementById("lat").innerHTML = x.lat;
  document.getElementById("long").innerHTML = x.long;
  document.getElementById("elev").innerHTML = x.elev;
  document.getElementById("acc").innerHTML = x.accuracy;
  document.getElementById("trans").innerHTML = x.transmission;
  document.getElementById("speed").innerHTML = x.speed;
  document.getElementById("head").innerHTML = x.heading;
  document.getElementById("angle").innerHTML = x.angle;
  document.getElementById("brake").innerHTML = x.accelSet;
  document.getElementById("size").innerHTML = x.size;
};

//Initiate map on webpage
function initMap() {
  //Create map and place on webpage using DOM centering it around pre-determined LAT&LONG
  map = new google.maps.Map(document.getElementById("map"), {
    center: home,
    zoom: 10, //How zoomed into the map do you want it
  });

  //Displays specific boxes for certain locations and zooms in on that location area
  $("#allSel").click(() => {
    map.setCenter(home); //sets location center
    document.getElementById("ksaw").style.display = "none"; //hides boxes of this location
    document.getElementById("ptc").style.display = "none"; //shows boxes of this location
    map.setZoom(15);
    clickMarker = ""; //removes marker selection
    clickLoc = ""; //Removes location selection
  });

  //Displays specific boxes for certain locations and zooms in on that location area
  $("#ksuSel").click(() => {
    map.setCenter(ksaw); //sets location center
    document.getElementById("ksaw").style.display = "initial"; //shows boxes of this location
    document.getElementById("ptc").style.display = "none"; //hides boxes of this location
    map.setZoom(15);
    $("#ksaw").empty(); //Empties KSAW container
    clickMarker = ""; //removes marker selection
    clickLoc = "kennesaw"; //Location Kennesaw is selected
    socket.emit("selKSU"); //Joins KSU room
  });

  //Displays specific boxes for certain locations and zooms in on that location area
  $("#ptcSel").click(() => {
    map.setCenter(ptc); //sets location center
    document.getElementById("ksaw").style.display = "none"; //hides boxes of this location
    document.getElementById("ptc").style.display = "initial"; //hides boxes of this location
    map.setZoom(15);
    $("#ptc").empty(); //Empties PTC container
    clickMarker = ""; //removes marker selection
    clickLoc = "ptc"; //Location PTC is selected
    socket.emit("selPTC"); //Joins PTC room
  });

  // Once data is received through the socket
  socket.on("data", (x) => {
    // Pull the name out of the JSON object and remove the quotes from it
    let id = x.id;
    let name = id.replace(/^["'](.+(?=["']$))["']$/, "$1");

    // Check the Marker Store object and if the name already exist within the change the position of the marker value.
    if (markerStore.hasOwnProperty(name)) {
      markerStore[name].setPosition({ lat: x.Lat, lng: x.Lon });
      if (!$("#" + name + "").length) {
        boxCar(name); //Creates box container within the correct location container
      }
      // Otherwise create the marker and add it the the marker store object
    } else {
      let marker = new google.maps.Marker({
        position: { lat: x.Lat, lng: x.Lon },
        map: map,
        title: name,
        icon: image, //image of car marker
      });

      boxCar(name); //Creates box container within the correct location container
      markerStore[name] = marker; //Adds marker to the Marker object
    }

    // If specific box is selected -> will zoom in on box and display the data from that box
    if (clickMarker === name) {
      map.setCenter(markerStore[name].position);
      map.setZoom(18); //sets zoom of map to specific marker
      $("#data").empty();
      boxData(x);
    }

    // Declares what box is being clicked on
    $("#" + name + "").click(() => {
      clickMarker = name; //Defines what marker is clicked
    });
  });
}

let map;
const image = "https://img.icons8.com/fluent/48/000000/car-top-view.png";
let clickMarker;
const socket = io();

const filler = { lat: xx.xxxxx, lng: xx.xxxxx }; //Filler initial coordinated to center the map and marker
const home = { lat: xx.xxxxx, lng: xx.xxxxx }; //Initial coordinated to center the map and marker
const ksaw = { lat: xx.xxxxx, lng: xx.xxxxx }; //Coordinates for Marietta campus of KSAW
const ptc = { lat: xx.xxxxx, lng: xx.xxxxx }; //Coordinates for city hall Peachtree Corners

//Initiate map on webpage
function initMap() {
  //Create map and place on webpage using DOM centering it around pre-determined LAT&LONG
  map = new google.maps.Map(document.getElementById("map"), {
    center: filler,
    zoom: 12, //How zoomed into the map do you want it
  });

  // Create marker with it's intial position being home
  const cb1_marker = new google.maps.Marker({
    position: home, //Pre-determined coordinates
    map: map,
    icon: image, //image of car marker
  });

  //Create marker with it's intial position being home
  const cb2_marker = new google.maps.Marker({
    position: home, //Pre-determined coordinates
    map: map,
    icon: image, //image of car marker
  });

  // //Loop through the array of coordinates/trip to simulate trip...
  carBox2.forEach((y, i) => {
    //loops through coordinates (y) and adds a delay of (i) between each set of coordinates
    setTimeout(() => {
      cb2_marker.setPosition({ lat: y.Lat, lng: y.Lon }); //sets new position of marker with current y-coordinates

      //Zooms in on specific box when clicked
      if (clickMarker === "carBox2") {
        map.setCenter(cb2_marker.position); //sets center of map with current y-coordinates
        map.setZoom(18); //sets zoom of map to specific marker
        $("#data").empty();
        document.getElementById("data").innerHTML = JSON.stringify(y);
      }
      $("#cbox2").click(() => {
        clickMarker = "carBox2"; //Defines what marker is clicked
      });
    }, i * 200); // i*500, creates a delay of 500 milliseconds (or .5 seconds) between each coordinate output
  });

  //Displays specific boxes for certain locations and zooms in on that location area
  $("#allSel").click(() => {
    map.setCenter(home); //sets location center
    document.getElementById("ksaw").style.display = "none"; //hides boxes of this location
    document.getElementById("ptc").style.display = "initial"; //shows boxes of this location
    map.setZoom(15);
    clickMarker = "";
  });

  //Displays specific boxes for certain locations and zooms in on that location area
  $("#ksuSel").click(() => {
    map.setCenter(ksaw); //sets location center
    document.getElementById("ksaw").style.display = "initial"; //shows boxes of this location
    document.getElementById("ptc").style.display = "none"; //hides boxes of this location
    map.setZoom(15);
    clickMarker = ""; //removes marker selection
    socket.emit("selKSU");
  });

  //Displays specific boxes for certain locations and zooms in on that location area
  $("#ptcSel").click(() => {
    map.setCenter(ptc); //sets location center
    document.getElementById("ksaw").style.display = "none"; //hides boxes of this location
    document.getElementById("ptc").style.display = "none"; //hides boxes of this location
    map.setZoom(15);
    clickMarker = ""; //removes marker selection
    socket.emit("selPTC");
  });

  socket.on("data", (data) => {
    let x = data;
    cb1_marker.setPosition({ lat: x.Lat, lng: x.Lon }); //sets new position of marker with current x-coordinates
    //Zooms in on specific box when clicked
    if (clickMarker === "carBox1") {
      map.setCenter(cb1_marker.position);
      map.setZoom(18); //sets zoom of map to specific marker
      $("#data").empty();
      document.getElementById("data").innerHTML = JSON.stringify(x);
    }

    $("#cbox1").click(() => {
      clickMarker = "carBox1"; //Defines what marker is clicked
    });
  });
}

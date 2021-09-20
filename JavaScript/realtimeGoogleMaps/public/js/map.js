let map;
const image = "https://img.icons8.com/fluent/48/000000/car-top-view.png";
let clickMarker;

const home = { lat: xx.xxxxxx, lng: xx.xxxxx }; //Initial coordinated to center the map and marker

//Initiate map on webpage
function initMap() {
  //Create map and place on webpage using DOM centering it around pre-determined LAT&LONG
  map = new google.maps.Map(document.getElementById("map"), {
    center: filler,
    zoom: 15, //How zoomed into the map do you want it
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

  //Loop through the array of coordinates/trip to simulate trip...
  carBox1.forEach((x, i) => {
    //loops through coordinates (x) and adds a delay of (i) between each set of coordinates
    setTimeout(() => {
      cb1_marker.setPosition({ lat: x.Lat, lng: x.Lon }); //sets new position of marker with current x-coordinates

    }, i * 200); // i*500, creates a delay of 500 milliseconds (or .5 seconds) between each coordinate output
  });

  carBox2.forEach((y, i) => {
    //loops through coordinates (y) and adds a delay of (i) between each set of coordinates
    setTimeout(() => {
      cb2_marker.setPosition({ lat: y.Lat, lng: y.Lon }); //sets new position of marker with current y-coordinates

    }, i * 200); // i*500, creates a delay of 500 milliseconds (or .5 seconds) between each coordinate output
  });


}

let map;
const image = "https://img.icons8.com/fluent/48/000000/car-top-view.png";

const home = { lat: xx.xxxxxx, lng: xx.xxxxxx }; //Initial coordinated to center the map and marker

//Initiate map on webpage
function initMap() {
  //Create map and place on webpage using DOM centering it around pre-determined LAT&LONG
  map = new google.maps.Map(document.getElementById("map"), {
    center: home,
    zoom: 18, //How zoomed into the map do you want it
  });

  //Create marker with it's intial position being home
  const marker = new google.maps.Marker({
    position: home, //Pre-determined coordinates
    map: map,
    icon: image, //image of car marker
  });

  //Loop through the array of coordinates/trip to simulate trip...
  mapLoc.forEach((x, i) => {
    //loops through coordinates (x) and adds a delay of i between each set of coordinates
    setTimeout(() => {
      marker.setPosition({ lat: x.Lat, lng: x.Lon }); //sets new position of marker with current x-coordinates
      map.setCenter({ lat: x.Lat, lng: x.Lon }); //sets center of map with current x-coordinates
    }, i * 500); // i*500, creates a delay of 500 milliseconds (or .5 seconds) between each coordinate output
  });
  //Replace array of pre-made coordinates with a data-fetch of real-time coordinates to have a map with up-to-date locations
}

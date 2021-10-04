- Map is set up to read through an array of coordinates saved in another js (mapdata.js) as well as read in data from outside the server through sockets.
- Data is brought into the server and then filtered and sent to the correct socket room.
- Loop through array changing the position of the marker with the coordinates of the array. 
- Put the marker setting statement  in a set timeout function within the loop in order to delay the loop output of each set of coordinate to simulate real time mapping. 
 
***** Replace array of coordinates with a fetch of data from an api or websocket to get up-to-date -> real time  maping *****
  

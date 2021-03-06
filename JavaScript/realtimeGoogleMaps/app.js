const express = require("express");
const app = express(); //Declare express server

app.set("view engine", "ejs"); //Set view to ejs
app.use(express.static("public")); //declare file locations

//render index page on path '/'
app.get("/", (req, res) => {
  res.render("index");
});

//render information on path '/markers'
app.get("/markers", (req, res) => {});

//listen for/access server on localhost port 3000
app.listen(3000, () => {
  console.log("Server is running");
});

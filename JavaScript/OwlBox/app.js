const { json } = require("express");
const express = require("express");
const cors = require("cors");
const app = express(); //Declare express server
const corsOptions = {
  origin: "http://localhost:3000/",
  credentials: true, //access-control-allow-credentials:true
  optionSuccessStatus: 200,
};

app.set("view engine", "ejs"); //Set view to ejs
app.use(express.static("public")); //declare file locations
app.use(express.urlencoded({ extended: true }));
app.use(express.json()); //Use JSON within express
app.use(cors(corsOptions)); //Bypass webpage security

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

//jshint esversion:6

const express = require("express");
const https = require("https");
const bodyParser = require("body-parser");

const app = express();

app.use(bodyParser.urlencoded({
  extended: true
}));

app.get("/", function(req, res) {
  res.sendFile(__dirname + "/index.html");
});

app.post("/", function(req, res) {
  const query = req.body.cityName;
  const apikey = "43047e1dff7164957af09f6fabc5e474";
  const unit = "imperial";
  const url = "https://api.openweathermap.org/data/2.5/weather?q=" + query + "&appid=" + apikey + "&units=" + unit;
  https.get(url, function(response) {
    console.log(response.statuscode);

    response.on("data", function(data) {
      const weatherData = JSON.parse(data);
      const temp = weatherData.main.temp;
      const desc = weatherData.weather[0].description;
      const icon = weatherData.weather[0].icon;
      const imageURL = "https://openweathermap.org/img/wn/" + icon + "@2x.png";
      res.write("<p>The weather is currently " + desc + "</p>");
      res.write("<h1>The temperature in " + query + " is " + temp + " degrees F</h1>");
      res.write("<img src=" + imageURL + ">");
      res.send();


    });
  });

});




app.listen(3000, function() {
  console.log("Server is running on port 3000");
});
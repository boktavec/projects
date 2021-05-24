//jshint esversion:6

const express = require("express");
const bodyParser = require("body-parser");

const app = express();
app.use(bodyParser.urlencoded({extended: true}));

app.get("/", function(req, res){
  res.sendFile(__dirname + "/index.html"); //filepath no matter the computer
});

app.get("/bmicalculator", function(req, res){
  res.sendFile(__dirname + "/bmiCalculator.html");
});

app.post("/bmicalculator", function(req, res){
  var weight = Number(req.body.Weight); //req.body.(name of element)
  var height = Number(req.body.Height);

  var bmi = weight / height * height;

  res.send("Your BMI is: " + bmi);
});


app.post("/", function(req, res){
  var num1 = Number(req.body.num1);
  var num2 = Number(req.body.num2);

  var results = num1 + num2;

  res.send("The answer to the calculations is: " + results);
});

app.listen(3000, function(){
  console.log("Server is running on port 3000");
});

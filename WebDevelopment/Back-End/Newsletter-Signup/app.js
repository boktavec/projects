// jshint esversion:6

const express = require("express");
const bodyParser = require("body-parser");
const request = require("request");
const https = require("https");
// const mailchimp = require("mailchimp");

const app = express();

app.use(express.json());
app.use(express.static("public"));
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

app.get("/", function(req, res) {
  res.sendFile(__dirname + "/signup.html");
});

app.post("/", function(req, res) {

  const firstName = req.body.fName;
  const lastName = req.body.lName;
  const email = req.body.email;

  const data = {
   members: [
     {
       email_address: email,
       status: "subscribed",
       merge_fields: {
         FNAME: firstName,
         LNAME: lastName
       }
     }
   ]
  };

  const jsonData = JSON.stringify(data);

  const url = "https://us1.api.mailchimp.com/3.0/lists/db5baef74b";

  const options = {
    method: "POST",
    auth: "briano:baf4f57deab634b208a4ca6362a1f7f2-us1"
  };

  const request = https.request(url, options, function(response){
    response.on("data", function(data){
      console.log(JSON.parse(data));
    });
  });

request.write(jsonData);
request.end();

});

app.listen(3000, function() {
  console.log("Server is running on port 3000");
});


//API Key
// baf4f57deab634b208a4ca6362a1f7f2-us1

//List ID
// db5baef74b

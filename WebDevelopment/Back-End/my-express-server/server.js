const express = require("express");

const app = express();

app.get("/", function(request, response){
  response.send("<h1>Hello, World!</h1>");
}); // "/" represents root/homepage

app.get("/contact", function(request, response){
  response.send("Contact me at : asdasf@gmail.com");
});

app.get("/about", function(request, response){
  response.send("My name is brian and i am a butt guy");
});

app.listen(3000, function(){
  console.log("server started on port 3000");
});

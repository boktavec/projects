//jshint esversion:6

const superheroes = require("superheroes");
const supervillains = require("supervillains");

var mySuperheroName = superheroes.random();
var mySupervillainName = supervillains.random();

console.log("Superhero name: " + mySuperheroName);
console.log("Supervillain name: " + mySupervillainName);

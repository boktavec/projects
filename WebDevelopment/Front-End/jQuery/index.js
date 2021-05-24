// $("h1").text("Bye");
//
// $("button").html("<em>Hey</em>");

// $("h1").on("click", function() {
//   $("h1").hide();
// });


$("button").on("click", function() {
  $("h1").slideUp().slideDown().animate({opacity: 0.5});
});

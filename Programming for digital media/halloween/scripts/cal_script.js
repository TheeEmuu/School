
//highlights current day with green
var d = new Date();
$("#" + d.getDate()).css("background-color", "#2dad33");

$("ul li").hover(function() {
    $(this).animate({
        opacity: '0.5'}, "fast")
}, function(){$(this).stop();
              $(this).css("opacity", "1");
});

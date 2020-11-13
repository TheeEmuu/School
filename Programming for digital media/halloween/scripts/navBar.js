var script = document.createElement('script');
script.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

$(document).ready(function(){
    $("#home").click(function(){
        window.location.href = "home.html";
    })

    $("#attractions").hover(function(){
        $("#attractions").find("ul").css("display", "block");
    }, function(){
        $("#attractions").find("ul").css("display", "none");
    });

    $("#attractions").click(function(){
        window.location.href = "attractions.html";
    });

    $("#calendar").click(function(){
        window.location.href = "calendar.html";
    });

    $("#contact").click(function(){
        window.location.href = "contact.html";
    });
});
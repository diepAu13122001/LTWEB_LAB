var time = 1000;
var image = 'Baymax.png';
var turnAngle = 0;

function turn() {
    image.setAttribute("style", "transform: rotate(" + turnAngle + "deg)");
    turnAngle = turnAngle + 15;
    // setTimeout("turn()", time);
}
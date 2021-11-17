const button = document.querySelector('.btn-random');

var button1 = document.getElementById("red");
var button2 = document.getElementById("yellow");
var button3 = document.getElementById("pink");
var button4 = document.getElementById("gray");
var button5 = document.getElementById("black");
var button6 = document.getElementById("orange");
var button7 = document.getElementById("blue");
const background = document.querySelector('.background');

button1.onclick = function () {
    background.style.backgroundColor = 'red';
}

button2.onclick = function () {
    background.style.backgroundColor = 'yellow';
}

button3.onclick = function () {
    background.style.backgroundColor = 'pink';
}

button4.onclick = function () {
    background.style.backgroundColor = 'gray';
}

button5.onclick = function () {
    background.style.backgroundColor = 'black';
}

button6.onclick = function () {
    background.style.backgroundColor = 'orange';
}

button7.onclick = function () {
    background.style.backgroundColor = 'blue';
}
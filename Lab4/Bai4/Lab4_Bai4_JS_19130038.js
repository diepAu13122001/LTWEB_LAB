function countString() {
    var textarea = document.getElementById('textarea').value;
    var field = document.getElementById('field').value;
    var count = textarea.split(field).length-1;
    alert(count);
}
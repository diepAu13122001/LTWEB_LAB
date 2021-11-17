function giai_ptb2(form) {
    var x1, x2;
    var x, y, z, delta;
    x = parseInt(form.a.value);
    y = parseInt(form.b.value);
    z = parseInt(form.c.value);
    delta = (y * y - 4 * x * z);
    if (delta == 0) {
        x1 = -y / (2 * x);
        x2 = -y / (2 * x);
        alert("phuong trinh co nghiem kep");
        form.kq1.value = eval(x1);
        form.kq2.value = eval(x2);
    } else if (delta < 0) {
        alert("phuong trinh vo nghiem");
    } else {
        x1 = (-y - Math.sqrt(delta)) / (2 * x);
        x2 = (-y + Math.sqrt(delta)) / (2 * x);
        alert("phuong trinh co hai nghiem");
        form.kq1.value = eval(x1);
        form.kq2.value = eval(x2);
    }
}
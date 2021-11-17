// importing packages
const express = require('express');
const admin = require('firebase-admin');
const  bcrypt = require('path');

//initializing express.js

const app = express();

//routes
//home route
app.get("/", (reg, res) =>{
    res.sendFile(path.join(__dirname, "public", "index.html"));
})

app.listen(3000, () =>{
    console.log('listening on port 3000........');
})
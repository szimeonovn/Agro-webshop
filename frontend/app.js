
var express = require('express');
var app = express();

app.use(express.static('app'));

app.get('/', function (req, res) {
    res.sendFile('app/index.html', {root: __dirname});
});

var port = process.env.PORT || 3000;

app.listen(port, function () {
    console.log('App listening on port ' + port + '!')
});

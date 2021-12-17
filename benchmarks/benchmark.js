const express = require('express');
const nocache = require('nocache');
const request = require("request");
const app = express();
const port = 3000;

app.get('/', (req, res) => res.send('Hello World!'));
app.listen(port, () => console.log(`Example app listening on port ${port}!`));
app.set('etag', false)
app.use(nocache());


app.use((req, res, next) => {
    res.set('Cache-Control', 'no-store')
    next()
})

app.get("/benchmark_imperative_item", (req,res) => {
    const start = Date.now();
    var request = require('request');
    var options = {
        'method': 'GET',
        'url': 'http://localhost:8090/imperative/items',
        'headers': {
        }
    };
    request(options, function (error, response) {
        if (error) throw new Error(error);
        // console.log(response.body);
        const end = Date.now();
        console.log(end - start);
    });

    res.json("SUCCESS");
});

app.get("/benchmark_reactive_item", (req,res) => {
    const start = Date.now();
    var request = require('request');
    var options = {
        'method': 'GET',
        'url': 'http://localhost:8090/reactive/items',
        'headers': {
        }
    };
    request(options, function (error, response) {
        if (error) throw new Error(error);
        // console.log(response.body);
        const end = Date.now();
        console.log(end - start);
    });

    res.json("SUCCESS");
});
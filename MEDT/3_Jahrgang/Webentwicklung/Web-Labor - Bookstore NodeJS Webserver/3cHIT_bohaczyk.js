var http = require('http');
var url = require('url');

glid = 1;

function buch(name1, autor1, jahr1, seitenanzahl1) 
  {
  this.id = glid++,
  this.name = name1,
  this.autor = autor1,
  this.jahr = jahr1,
  this.seitenanzahl = seitenanzahl1
}
var array = [] 

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    var u = url.parse(req.url, true);
    
    if(u.pathname == "/add") {
      array.push(new buch(u.query.name, u.query.autor, u.query.jahr, u.query.seitenanzahl));
    }
    
    if(u.pathname == "/del") {

      for(var i = 0; i < array.length; i++) {
          if(array[i].id == u.query.id) {
            array.splice(i, 1);
          }
      }
    }
    if(u.pathname == "/update") {
      for(var i = 0; i < array.length; i++) {
              if(array[i].id == u.query.id) {
                array[i].name = u.query.name;
                array[i].autor = u.query.autor;
                array[i].jahr = u.query.jahr;
                array[i].seiten = u.query.seitenanzahl;
              }
          }
    }

    res.end(JSON.stringify(array));

  }).listen(8080); 

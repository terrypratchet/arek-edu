var pgp = require('pg-promise');
var connection = "postgres://username:password@localhost:7777/database";
var db = pgp(connection);

db.any("select * from users where active=$1", [true])
    .then(data => {
        // success;
    })
    .catch(error => {
        // error;
    });




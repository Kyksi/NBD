// -- Find all people in the database with weight in the <68, 71.5) range
printjson(db.people.find({weight : {$gte : "68", $lt : "71.5"}}).toArray())

// -- Remove people with height >190cm from the database
printjson(db.people.remove({height : {$gt : "190"}}))

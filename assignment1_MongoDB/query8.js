// -- Replace “Moscow” with “Moskwa” in city names for all people in the database
printjson(db.people.updateMany({"location.city" : "Moscow"}, {$set : {"location.city" : "Moskwa"}}))

// -- Add property “hobby” with value “table tennis” to all people with first name “Antonio”
printjson(db.people.updateMany({first_name : "Antonio"}, {$set : {hobby : "table tennis"}}))

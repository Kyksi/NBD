// -- Remove the “email” property from all people having “Editor” as their job
printjson(db.people.updateMany({job : "Editor"}, {$unset : {email : 1}}))

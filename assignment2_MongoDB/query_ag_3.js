// -- List of unique jobs
printjson(db.people.aggregate([{$group : {_id : "$job",  count : {$sum : 1}}}]).toArray());

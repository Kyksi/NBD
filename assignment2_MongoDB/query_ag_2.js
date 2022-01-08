// -- Total amount of money left on credit cards of people in database, grouped by currency
printjson(db.people.aggregate([
	{$unwind : "$credit"},
	{$group : {_id : "$credit.currency", totalBalance : {$sum : {$toDouble : "$credit.balance"}}}}
]).toArray());

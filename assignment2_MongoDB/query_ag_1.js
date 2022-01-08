// -- Average weight and height of people in the database, grouped by gender 
//	(so separate values for men and women)
printjson(db.people.aggregate([
	{
		$group : {
			_id : "$sex",
			avgWeight : {$avg : {$toDouble : "$weight"}},
			avgHeight : {$avg : {$toDouble : "$height"}}
		}
	}
]).toArray())

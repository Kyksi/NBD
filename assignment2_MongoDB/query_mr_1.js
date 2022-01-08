// -- Average weight and height of people in the database, grouped by gender 
//	(so separate values for men and women)
printjson(db.people.mapReduce(
  function() {
  	emit(this.sex, {weight : parseFloat(this.weight), height : parseFloat(this.height), count : 1});
  },
  function(key, values) {
  	reducedVal = { count : 0, weight : 0, height : 0 };
  	for (var idx = 0; idx < values.length; idx++) {
  		reducedVal.count += values[idx].count;
  		reducedVal.weight += values[idx].weight;
		reducedVal.height += values[idx].height;
	}
	return reducedVal;
  },
  {
	out: "avg_weight_and_heigth",
	finalize: function (key, reducedValue) {
		return {
			avgWeight : reducedValue.weight / reducedValue.count,
			avgHeight : reducedValue.height / reducedValue.count
		};
	}
  }
).find().toArray());

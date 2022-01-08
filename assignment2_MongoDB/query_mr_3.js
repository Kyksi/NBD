// -- List of unique jobs
printjson(db.people.mapReduce(
  function() {
    emit(this.job, 1);
  },
  function(key, values) {
    return Array.sum(values);
  },
	{
		out: "jobs"
	}
).find().toArray());

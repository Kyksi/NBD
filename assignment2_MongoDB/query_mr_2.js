// -- Total amount of money left on credit cards of people in database, grouped by currency
printjson(db.people.mapReduce(
  function() {
    this.credit.forEach(credit => {
      emit(credit.currency, parseFloat(credit.balance))
    });
  },
  function(key, values) {
    // return Array.sum(values)
    totalBalance = 0;
	  for (var idx = 0; idx < values.length; idx++) {
		  totalBalance += values[idx];
	  }
    return totalBalance;
  },
	{
		out: "total_balance"
	}
).find().toArray());

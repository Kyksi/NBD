// -- Average and total amount of money left on credit cards of polish women, grouped by currency
printjson(db.people.mapReduce(
  function() {
    this.credit.forEach(credit => {
      emit(credit.currency, parseFloat(credit.balance))
    });
  },
  function(key, values) {
    return {
      "avgBalance" : Array.sum(values) / values.length,
      "totalBalance" : Array.sum(values)
    }
  },
  {
    out: "avg_and_total_female_balance",
    query: {
      sex : "Female",
      nationality : "Poland"
    }
  }
).find().toArray());

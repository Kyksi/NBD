// -- Average and total amount of money left on credit cards of polish women, grouped by currency
printjson(db.people.aggregate([
  {$match : {
      nationality : "Poland",
      sex : "Female"
    }
  },
  {$unwind : "$credit"},
  {$group : {
      _id : "$credit.currency",
      "avgBalance" : {$avg : {$toDouble : "$credit.balance"}},
      "totalBalance" : {$sum : {$toDouble : "$credit.balance"}}
    }
  }
]).toArray());

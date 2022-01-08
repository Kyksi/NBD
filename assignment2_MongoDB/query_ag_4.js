// -- Average, minimum and maximum BMI (weight/height^2) grouped by nationality
printjson(db.people.aggregate([
  {$addFields: {
      bmi : {$divide : [{$toDouble:"$weight"}, {$pow : [{$divide : [{$toDouble:"$height"}, 100]}, 2]}]}
    }
  },
  {$group : {
      _id : "$nationality",
      avgBMI : {$avg : "$bmi"},
      minBMI : {$min : "$bmi"},
      maxBMI : {$max : "$bmi"}
    }
  }
]).toArray());

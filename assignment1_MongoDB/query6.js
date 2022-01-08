// -- Add yourself to the database
// (data on credit card, address and weight may be fictional)
printjson(db.people.insertOne(
  {
		"sex" : "Male",
		"first_name" : "Nazar",
		"last_name" : "Semeniuk",
		"job" : "DevOps Engineer",
		"email" : "s24015@pjwstk.edu.pl",
		"location" : {
			"city" : "Warsaw",
			"address" : {
				"streetname" : "Street",
				"streetnumber" : "101"
			}
		},
		"description" : "Computer Science, DevOps",
		"height" : "183.5",
		"weight" : "80.0",
		"birth_date" : "2000-01-04T09:41:59Z",
		"nationality" : "Ukraine",
		"credit" : [
			{
				"type" : "visa",
				"number" : "1234876501236789",
				"currency" : "PLN",
				"balance" : "10211.53"
			}
		]
	}
))

object Main {

  def main(args: Array[String]): Unit = {

    println("=============== Task 1 ===============")
    println("Thursday: " + getDayInfo("Thursday") + ";")
    println("Moonday: " + getDayInfo("Moonday") + ";")
    println("Saturday: " + getDayInfo("Saturday") + ";")


    println("=============== Task 2 ===============")

    println("--- Bank Account 1 --- (initial ballance to 0)")
    var bankAccount1 = new BankAccount()
    println("Ballance 1: " + bankAccount1.getBallance)
    bankAccount1.deposit(150000)
    println("Ballance 1: " + bankAccount1.getBallance)
    bankAccount1.withdraw(143700)
    println("Ballance 1: " + bankAccount1.getBallance)
    bankAccount1.withdraw(7000)
    println("Ballance 1: " + bankAccount1.getBallance)

    println("--- Bank Account 2 --- (accepting initial ballance)")
    var bankAccount2 = new BankAccount(5000052)
    println("Ballance 2: " + bankAccount2.getBallance)
    bankAccount2.withdraw(5000000)
    println("Ballance 2: " + bankAccount2.getBallance)
    bankAccount2.deposit(10000)
    println("Ballance 2: " + bankAccount2.getBallance)


    println("=============== Task 3 ===============")
    var person1 = new Person("Elizabeth", "Lincoln")
    var person2 = new Person("Charlotte", "Cooper")
    var person3 = new Person("Marie", "Delamare")
    var person4  = new Person("Victoria", "Ashworth")

    var listPerson = List[Person](person1, person2, person3, person4);
    for(person <- listPerson) {
      println(person.firstName + " " + person.lastName + ": " + patternMatching(person))
    }
  

    println("=============== Task 4 ===============")
    println("Applying the parameter function three times: " + useFunctionThreeTimes(4, multiplyByNine));
 
 
    println("=============== Task 5 ===============")
    val newPerson = new Person2("FirstName", "LastName")
    println("Person's tax: " + (newPerson.taxToPay * 100) + "% of salary;")
    val student = new Person2("Charlotte", "Cooper") with Student
    println("Student's tax: " + (student.taxToPay * 100) + "% of salary;")
    val employee = new Person2("Marie", "Delamare") with Employee
    println("Employee's tax: " + (employee.taxToPay * 100) + "% of salary;")
    val teacher = new Person2("Victoria", "Ashworth") with Teacher
    println("Teacher's tax: " + (teacher.taxToPay * 100) + "% of salary;")
    val teacherEmployee = new Person2("Victoria", "Ashworth") with Teacher with Employee
    println("Teacher-Employee's tax: " + (teacherEmployee.taxToPay * 100) + "% of salary;")
    val employeeTeacher = new Person2("Marie", "Delamare") with Employee with Teacher
    println("Employee-Teacher tax: " + (employeeTeacher.taxToPay * 100) + "% of salary;")
  }

//--------------- Task 1 ---------------//
  def getDayInfo(day: String): String = day.toUpperCase match {
    case "MONDAY"       =>   "Work"
    case "TUESDAY"      =>   "Work"
    case "WEDNESDAY"    =>   "Work"
    case "THURSDAY"     =>   "Work"
    case "FRIDAY"       =>   "Work"
    case "SATURDAY"     =>   "Weekend"
    case "SUNDAY"       =>   "Weekend"
    case  _             =>   "No such day"
  }


//--------------- Task 3 ---------------//
  case class Person(firstName: String, lastName: String)

  def patternMatching(person: Person) = person match {
    case Person("Elizabeth", "Lincoln") => "Hey Marie and Charlotte!"
    case Person("Marie", _) => "Hello Elizabeth Lincoln!"
    case Person(_, "Cooper") => "Good morning Elizabeth!"
    case default => "Hey, how are you doing?"
  }


//--------------- Task 4 ---------------//
  def multiplyByNine(value:Int):Int = { value * 9 }
  def useFunctionThreeTimes(value: Int, func: Int => Int): Int = {
//    var result:Int = value
//    for (n <- 1 to 3) {
//      result = func(result)
//    }
//    result
    func(func(func(value)))
  }
}


//--------------- Task 2 ---------------//
class BankAccount() {
  private var ballance:Double = 0
  def getBallance = { ballance }

  def this(ballance:Double){
    this()
    this.ballance = ballance
  }

  def deposit(value: Double) {
    ballance += value
    println(value + " deposit.")
  }

  def withdraw(value: Double) {
    if (value <= ballance) {
      ballance -= value
      println(value + " withdrawal.")
    } else {
      println("There are insufficient funds in your account (" + value + ").")
    }
  }
}

//--------------- Task 5 ---------------//
  class Person2() {
    private var _firstName: String = ""
    private var _lastName: String = ""
    private var _taxToPay: Double = 0

    def this(firstName: String, lastName: String){
      this()
      this._firstName = firstName
      this._lastName = lastName
      this._taxToPay = 0
    }

    def firstName : String = { _firstName }
    def lastName : String = { _lastName }
    def taxToPay : Double = { _taxToPay }
  }

  trait Student extends Person2 {
    override def taxToPay:Double = 0.0
  }

  trait Employee extends Person2 {
    private var _salary:Double = 0

    private def setSalary(value: Double) {
      _salary = value
    }

    private def getSalary: Double = if(_salary > 0) { _salary * taxToPay } else { 0 }

    override def taxToPay: Double = 0.20
  }

  trait Teacher extends Employee {
    override def taxToPay: Double = 0.10
  }

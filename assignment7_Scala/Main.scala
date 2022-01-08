import scala.annotation.tailrec

object Main {

  def main(args: Array[String]): Unit = {
    println("=============== Task 1 ===============")
    val days = List[String]("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println("--- #1a")
    println(getListItemsByFor(days))
    println("--- #1b")
    println(getListItemsByForStartsWithP(days))
    println("--- #1c")
    println(getListItemsByWhile(days))


    println("=============== Task 2 ===============")
    println("--- #2a")
    println(recursive(days))
    println("--- #2b")
    println(backwardsRecursive(days))


    println("=============== Task 3 ===============")
    println(tailRecursive(days))


    println("=============== Task 4 ===============")
    println("--- #4a")
    println(getListItemsByFoldl(days))
    println("--- #4b")
    println(getListItemsByFoldr(days))
    println("--- #4c")
    println(getListItemsByFoldlStartsWithP(days))


    println("=============== Task 5 ===============")
    var products = Map("Milk" -> 4.0, "Coffee" -> 100.00)
    println("Before price reduction: " + products.map(_.productIterator.mkString(":")).mkString("; "))
    var products2 = getDiscount(products, 10);
    println("After price reduction: " + products2.map(_.productIterator.mkString(":")).mkString("; "))


    println("=============== Task 6 ===============")
    val integerValues2  = List[Int](99, 2, 0, 9, 2, 3, 3, 0, 0, 1)
    println("Before increasing by 1: " + integerValues2)
    println("After increasing by 1: " + getIncrementedList(integerValues2))


    println("=============== Task 7 ==============")
    val realNumbers  = List[Double](-1.2, 3.4, 5.5, -9.0, 1.6, 3.7, -3.0, 34.1)
    println("Lista przed filtrowaniem: " + realNumbers)
    println("Lista po filtrowaniu: " + getAbsoluteValuesList(realNumbers, -5.0, 12.0))


    println("=============== Task 8 ===============")
    println(getTupleValues(!false, 10.0f, 100))


    println("=============== Task 9 ===============")
    val integerValues = List[Int](1, 0, 4, 9, 2, 4, 4, 0, 0, 5, 0, 0, 3, 10, 0)
    println("Before removing 0: " + integerValues)
    println("After removing 0: " + getListWithoutZeros(integerValues))


    println("=============== Task 10 ===============")
    println(getMapItemValueByKey(products, "Coffee"))
  }


//--------------- Task 1 ---------------//
// -- 1a
  def getListItemsByFor(list: List[String]): String = {
    var resultStr:String = ""
    for(item <- list) {
      resultStr += (if(item != list.head) ", " else "") + item
    }
    resultStr
  }
// -- 1b
  def getListItemsByForStartsWithP(list: List[String]): String = {
    var resultStr:String = ""
    for(item <- list if item.startsWith("P")) {
      resultStr += (if(item != list.head) ", " else "") + item
    }
    resultStr
  }
// -- 1c
  def getListItemsByWhile(list: List[String]): String = {
    var resultStr:String = ""
    var i:Int = 0
    while(i < list.length) {
      resultStr += (if(list(i) != list.head) ", " else "") + list(i)
      i+=1
    }
    resultStr
  }
//--------------- Task 2 ---------------//
// -- 2a
  def recursive(list: List[String]): String = {
    if (list.length == 1) {
      list.head
    } else if (!list.isEmpty) {
      list.head + ", " + recursive(list.tail)
    } else {
      throw new Exception("List is Empty")
    }
  }
// -- 2b
  def backwardsRecursive(list: List[String]): String = {
    if (list.length == 1) {
      list.head
    } else if (!list.isEmpty) {
      backwardsRecursive(list.tail) + ", " + list.head
    } else {
      throw new Exception("List is Empty")
    }
  }
//--------------- Task 3 ---------------//
  @tailrec def tailRecursive(list: List[String], result: String = ""): String = {
    if (list.head != list.last) {
      // println(result.concat(list.head))
      tailRecursive(list.tail, result.concat(list.head) + ", ")
    } else {
      result.concat(list.head)
    }
  }
//--------------- Task 4 ---------------//
// -- 4a
  def getListItemsByFoldl(list: List[String]): String = {
    list.foldLeft("")((A, B) =>
      A + (if(B != list.head) ", " else "") + B
    )
  }
// -- 4b
  def getListItemsByFoldr(list: List[String]): String = {
    list.foldRight("")((A, B) =>
      (if(A != list.head) ", " else "") + A + B
    )
  }
// -- 4c
  def getListItemsByFoldlStartsWithP(list: List[String]): String = {
    list.foldLeft("")((A, B) =>
      A +(if (B.startsWith("P")) {
            ((if(B != list.head) ", " else "") + B)
          } else { "" })
    )
  }
//--------------- Task 5 ---------------//
  def getDiscount(map: Map[String, Double], percent: Double): Map[String, Double] = {
    map.view.mapValues(cost => {
      cost - cost * 0.01 * percent
    }).toMap
  }
//--------------- Task 6 ---------------//
  def getIncrementedList(list: List[Int]): List[Int] = {
    list.map(value => value + 1)
  }
//--------------- Task 7 ---------------//
  def getAbsoluteValuesList(list: List[Double], min: Double, max: Double): List[Double] = {
    list.filter(value => value >= min && value <= max)
      .map(value => value.abs)
  }
//--------------- Task 8 ---------------//
  def getTupleValues(tuple: (Any, Any, Any)): String = {
    (tuple._1.getClass.getSimpleName + ": " + tuple._1 + ";\n" +
      tuple._2.getClass.getSimpleName + ": " + tuple._2 + ";\n" +
      tuple._3.getClass.getSimpleName + ": " + tuple._3 + ";")
  }
//--------------- Task 9 ---------------//
  @tailrec
  def getListWithoutZeros(list: List[Int], result: List[Int] = List.empty[Int]): List[Int] = list match {
    case head::tail => {
      if (head != 0) {
        getListWithoutZeros(tail, result.appended(head))
      } else {
        getListWithoutZeros(tail, result)
      }
    }
    case Nil => result
  }
//--------------- Task 10 ---------------//
  def getMapItemValueByKey(map: Map[String, Double], key: String): Option[Double] = {
    map.get(key)
  }
}

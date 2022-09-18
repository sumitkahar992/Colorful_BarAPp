package com.example.test



fun main() {

//    var name = "Kotlin"  //mutable
//    val myName = "john"  //immutable

//    Basic Types in Kotlin:
//    (Whole Numbers)
//    -Int    32 bits
//    -Byte   8 bits
//    -Short  16 bits
//    (Floating Points Types)
//    (Decimal Numbers)
//    -Double
//    -Float
//    Note: for precision use Double.
//    val e = 2.7182818284
//    val eFloat = 2.7182818284f


//    val name: String
//    val age: Int
//    val myByte: Byte
//    val myShort: Short

//    myByte = 127
//    myShort = 12999

//    val number = 1000000000000  //Long
//    val oneLong = 1L
//
//
//    val a = 10
//    val b = 3
//    print(a % b)

//    val a = 23.0
//    val b = 12
//    print(a/b)

//
//    print("")


//    val amount = 0
////    if (amount == 1000) {
////        print("You're wealthy")
////    } else {
////        print("You are getting by")
////    }
//
//    when (amount) {
//        in 1..100 -> print("this amount is between 1 & 100")
//        !in 10..90 -> print("this amount is outside the range")
//        999 -> print("really close")
//        1000 -> print("Rich but not there")
//        1100 -> print("you've made it")
//        else -> {
////            print("$amount is just not going to work")
//        }
//
//    }


//
//    for (i in 1..100){
//        if (i%3 == 0)
//            println("$i is multiple of 3")
//        else
//            println("_")
//    }


//    Calculate(11, 1000, multipleOf = 11, message = "is multiple of ")

//    Calculate( 0, 100, "is multiple of ", 12)
//
//}
//fun Calculate(first: Int =1,   //default values
//              second: Int = 1000, //default values
//              message: String,
//              multipleOf: Int){
//    for (i in first..second){
//        if (i%multipleOf == 0){
//            println("$i $message $multipleOf")
//        }
//    }

//    val catAge = calculateCatAge(2)
////print("This cat is $catAge years old")
//    if(checkAge(catAge))
//        print("This cat is OLD ($catAge)")
//        else
//        print("This cat is YOUNG ($catAge)")


//  val  lambdaName : Type = { parameterList -> codeBody }
//    val sum: (Int, Int) -> Int = { a, b, -> a + b }
//   println(sum(12,12,"hello"))
//}

//    val catAge: (Int) -> Int = { age -> age * 7 }
//    print(catAge(7))

//    val catAge: (Int) -> Int = { it * 7 }
//    print(catAge(3))

//fun calculateCatAge(age: Int): Int = age * 7
//
//fun checkAge(catAge: Int): Boolean = catAge >= 14
//

//    val name: (String) -> Unit = { it -> print("Hello my name is $it")}
//   name("james")

//
//enhancedMessage(message = "Hello there, "){
//    print(it)
//    sum(12, 12)
//
//}
//
//// Trailing Lambda
//}
//fun enhancedMessage(message: String, funAsParameter: (String) -> Int){
//    println("$message ${funAsParameter("hey")}")
//}


    //Collections(list, Arrays, listOf)
    //Immutable list
//    val myListOfnames = listOf("Berlin","Tokyo","Professor","japan")
//                       //mutable list
//    val myMutableList = mutableListOf(12,34,1,5,2,422)
//      myMutableList.add(999)
//    val myNewList = mutableListOf<String>()
//    myNewList.add("kotliN")
//    myNewList.add("compose")
//    for (i in 1..10) {
//        myNewList.add(i, "Hey $i")
//    }
//    println(myNewList)
//
//    val myNewImmList = listOf<Int>(1,4,5,6)
//////      myMutableList.removeAt(0)
//        println("Number of elements ${myMutableList.size}")
//        println("second of elements ${myMutableList[1]}")
//
//        println("Index of elements \"1\" ${myMutableList.indexOf(1)}")
//        println(myMutableList)
//
//    //Lambda function
//    myListOfnames.forEach {
//        println(it)
//    }
//
//    for (item in myListOfnames){
////        println("Names: $item")
//    }


//   SET =           elements   Not in Order  // only unique number
    val mySet = setOf("US", "MZ", "AU")
//    println(mySet)
    val myMutableList = mutableSetOf(1, 2, 3, 4, 5, 6)
    myMutableList.add(1)

//    println(myMutableList)


//Map  =     immutable    keys to  values
//    val secretMap = mapOf("Up" to 1, "Down" to 2, "Left" to 3, "Right" to 4)
//    println(secretMap.keys)
//    println(secretMap.values)
//
//    if ("Up" in secretMap) println("yes is in !")
//    if (4 in secretMap.values) println("yes is in !")
//
//    val myMutableSecretMap = mutableMapOf("One" to 1, "Two" to 2, "Three" to 3)
//    myMutableSecretMap["Four"] = 4
//    println(myMutableSecretMap)
//
//
//    val emptyList = emptyList<String>()
//    val emptySet = emptySet<String>()
//    val emptyMap = emptyMap<String, Int>()



    val myListOfnames = listOf("Berlin","Tokyo","Prof","japan")
    val found = myListOfnames.filter {
//        it == "Berlin1"
//        it.length > 4
//        it.endsWith("n")
        it.startsWith("t")   // case sensitive
        it.startsWith("t",ignoreCase = true) && it.endsWith('O', ignoreCase = true)
    }
//    print(found)







     //object
//    val  car  =  Car()
//        car.color = "Blue"
//        car.model = "Bugati"
//    println(car.color)
//    println(car.model)
//    print(car.drive())
    val car = Car(color = "Green", model = "TATA")
    val secondCar = Car(color = "Purple", model = "Kia")
    println(car.color)
    println(car.model)
    println("Car color: ${car.color} \t model: ${car.model}")
    println("Car color: ${secondCar.color} \t model: ${secondCar.model}")


    car.speed(minSpeed = 100, maxSpeed = 199)
    car.drive()

    val truck = Truck(color = "Magenta", model = "F16")
    truck.drive()
    truck.speed(20,90)


}

class Truck(color: String, model: String) : Car(color, model){
    override fun speed(minSpeed: Int, maxSpeed: Int) {
        val fullSpeed = minSpeed * maxSpeed
        println("Truck full speed : $fullSpeed")

    }

    override fun drive() {
//        super.drive()
        println("vRoom is Like Truck!!")
    }
}



//OBJECTS
    //primary constructor
open class Car(var color: String ,
          var model: String ){
             //properties
    init {
        if (color == "Green"){
            println("Yayy Green")
        }else{
            println("$color is not Green")
        }
    }
//    init {
//        color = "Yello"
//        model = "Honda" }


   open fun drive(){                    //Behaviour, methods, fun
        println("Drive.....yroom")
    }

   open fun speed(minSpeed: Int, maxSpeed: Int ){
        println("Min Speed is: $minSpeed \t Max Speed is: $maxSpeed")
    }


}












































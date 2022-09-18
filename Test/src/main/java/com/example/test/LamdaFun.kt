package com.example.test


fun main() {

    val lambda: (Int) -> Int = { a ->
        a + 6
    }
    println(lambda(10))

    println(
        myFun(5) {              //Trailing Lambda
            it - 6
        })

    println(
        simplify("-")(2,3).toString()
    )


}


fun myFun(input: Int, anotherFun: (Int) -> Int): Int {
    return anotherFun(input)
}


fun simplify(operator: String): (Int, Int) -> Int {
    return when (operator) {

        "+" -> { a: Int, b: Int ->
            a + b
        }
        "-" -> { a: Int, b: Int ->
            a - b
        }
        "*" -> { a: Int, b: Int ->
            a * b
        }

        else -> { a: Int, b: Int ->
            a / b
        }


    }
}





















package com.example.test


var board = arrayListOf<ArrayList<String>>()
fun main(args: Array<String>){

    for (i in 0..2){
        val row = arrayListOf<String>()
        for (j in 0..2)
            row.add("")
            board.add(row)
    }

    printBoard()


    var continueGame = true

    do {
        println("Please enter a positions (e.g. 1, 1)")
        val input = readLine()?:""
        var x = 0
        var y = 0
        try {
            val positions = input.split(",")
            x = positions[0].trim().toInt()
            y = positions[1].trim().toInt()

            if (board[x-1][y-1] != ""){
                println("That positions is already taken, try again mc")
            }else{
                board[x-1][y-1] = "x"
                printBoard()
            }
        }catch (e: Exception){
            println("Invalid input, please try again bc")
        }

    }while (continueGame)







}

fun printBoard(){
    println("-------------")
    for (i in 0..2){
        for (j in 0..2){
            when(board[i][j]){
                "x" -> print("| x ")
                "o" -> print("| 0 ")
                else -> print("|   ")
            }
        }
        println("|")
        println("-------------")
    }
}
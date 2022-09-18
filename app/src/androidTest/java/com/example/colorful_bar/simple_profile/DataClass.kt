package com.example.colorful_bar.test

fun main(){


    val person = Person(
        name = "Joe",
        lastName = "Biden",
        age = 23)
    val Anita = Person(
        name = "Anita",
        lastName = "kahar",
        age = 27)
    val Dipak = Person(
        name = "Dipak",
        lastName = "kahar",
        age = 28)
    val Ananya = Person(
        name = "Ananya",
        lastName = "kahar",
        age = 8)
    val listOfPeople = listOf(Anita,Dipak,Ananya)
    listOfPeople.forEach { item ->
        println(item.name)
        println(item.age)
    }

println(person)
    
}

//data class
data class Person(val name: String,
                  val lastName: String,
                  val age: Int)


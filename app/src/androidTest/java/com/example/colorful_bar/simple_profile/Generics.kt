package com.example.colorful_bar.test

//GENERICS TYPE <T>
fun main(){

    val listOfItems = listOf("Tokyo","Berlin","NewYork","8848",999)
    val listOfNumbers = listOf(1,2,3,4,5,6,8,98)

    val finder = Finder(list = listOfItems)

    finder.findItem(element = 999){
        println("Found $it")
    }

}
class Finder<T>(private val list: List<T>){
    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
        val itemFoundList = list.filter {
            it == element
        }
        if (itemFoundList.isNullOrEmpty()) foundItem(null) else
            foundItem(itemFoundList.first())
    }
}

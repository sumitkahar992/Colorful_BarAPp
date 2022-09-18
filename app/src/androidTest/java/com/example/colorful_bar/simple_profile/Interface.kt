package com.example.colorful_bar.test

fun main(){

val button = Button(lable = "Button")
    button.onClick(message = "This is a Button")

    val superMario = Character(name = "SuperMario")
    superMario.onClick(message = "This is an actor")



}

class Button(val lable: String): ClickEvent {
    override fun onClick(message: String) {
        println("Clicked by $lable and here's a message $message")
    }
}

class Character(val name: String): ClickEvent{
    override fun onClick(message: String) {
        println("Clicked by $name and a message $message")
    }

}



//Interfaces
    interface ClickEvent {
    fun onClick(message: String)


}
















package firstunittest

import kotlinx.coroutines.*

fun main() {

    println("Program Execution will now Block")

    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            delay(1000)
            println("This is run from ${coroutineContext.get(CoroutineName.Key)}")
            println("Task from runBlocking")
        }


        GlobalScope.launch {
            delay(500)
            println("Task from GlobalScope")
        }


        coroutineScope {
            launch {
                delay(1500)
                println("Task from CoroutineScope")
            }
        }
    }
    println("Program execution will now continue")

}













//    GlobalScope.launch {
//        delay(2000)
//        println("World !")
//    }
//
//    print("Hello, ")
//    Thread.sleep(3000)


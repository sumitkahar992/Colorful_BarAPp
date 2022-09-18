package firstunittest

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun main(){

    runBlocking {
        val firstDeferred = async { getFirstValue() }
        val secondDeferred = async { getSecondValue() }

        println("Doing Some Processing Here")
        delay(500)
        println("Waiting for values")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()

        println("The Total is ${firstValue + secondValue}")
    }

}

suspend fun getFirstValue(): Int {
    delay(1000)
    val value = Random.nextInt(100)
    println("Returning First Value $value")
    return value
}


suspend fun getSecondValue(): Int {
    delay(2000)
    val value = Random.nextInt(1000)
    println("Returning Second Value $value")
    return value
}
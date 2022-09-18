package com.example.test

import java.io.IOException

fun main(){

//    val input = Result.ERROR
//    getResult(result = input)
    Repository.startFetch()
    getResult(Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())

    Repository.anotherCustomFailure()
    getResult(result = Repository.getCurrentState())

    Repository.customFailure()
    getResult(result = Repository.getCurrentState())



}
fun getResult(result: Result){
    return when(result){
        is Error -> {
            println(result.exception.toString())
        }
        is Success -> {
            println(result.dataFetched?: "Ensure you start the fetch function first")
        }
        is Loading -> {
            println("Loading...")
        }
        is NotLoading -> {
            println("Idle")
        }
        is Failure.AnotherCustomFailure -> {
            println(result.antherCustomfailure.toString())
        }
        is Failure.CustomFailure -> {
            println(result.customFalure.toString())
        }
        else -> {}
    }                              //better than both worlds
}

sealed class Result

data class Success(val dataFetched: String?): Result()
data class Error(val exception: Exception): Result()
object NotLoading: Result()
object Loading: Result()

sealed class Failure: Result(){
    data class CustomFailure(val customFalure: IOException): Failure()
    data class AnotherCustomFailure(val antherCustomfailure: NullPointerException): Failure()
}


//enum class Result {
//    SUCCESS,          // SUCCESS(data: String)      //Limitation
//    ERROR,            //absctract class              //overcome
//    IDLE,
//    LOADING
//}

object Repository {
    private var loadstate: Result = NotLoading
    private var dataFetched: String? = null

    fun startFetch(){
        loadstate = Loading
        dataFetched = "data"
    }
    fun finishedFetch(){
        loadstate = Success(dataFetched)
        dataFetched = null
    }
    fun error(){
        loadstate = Error(exception = Exception("Exception.."))
    }
    fun getCurrentState(): Result {
        return loadstate
    }
    fun customFailure(){
        loadstate = Failure.AnotherCustomFailure(antherCustomfailure = NullPointerException("Something went Wrong?"))
    }
    fun anotherCustomFailure(){
        loadstate = Failure.CustomFailure(customFalure = IOException("custom Failure"))
    }

}







































////Abstract class
//
//fun main(){
//
////    val input = Result.ERROR
////    getResult(result = input)
//    Repository.startFetch()
//    getResult(Repository.getCurrentState())
//    Repository.finishedFetch()
//    getResult(Repository.getCurrentState())
//    Repository.error()
//    getResult(Repository.getCurrentState())
//
//
//}
//fun getResult(result: Result){
//    return when(result){
//        is com.example.test.Error -> {
//            println(result.exception.toString())
//        }
//        is Success -> {
//            println(result.dataFetched?: "Ensure you start the fetch function first")
//        }
//        is Loading -> {
//            println("Loading...")
//        }
//        is NotLoading -> {
//            println("Idle")
//        }
//
//        else -> println("N/A")      //limitation of abstract class
//                                    //overcome    sealed class
//    }                              //better than both worlds
//}
//
//abstract class Result
//
//data class Success(val dataFetched: String?): Result()
//data class Error(val exception: Exception): Result()
//object NotLoading: Result()
//object Loading: Result()
//
//
////enum class Result {
////    SUCCESS,          // SUCCESS(data: String)      //Limitation
////    ERROR,            //absctract class              //overcome
////    IDLE,
////    LOADING
////}
//
//object Repository {
//    private var loadstate: Result = NotLoading
//    private var dataFetched: String? = null
//
//    fun startFetch(){
//        loadstate = Loading
//        dataFetched = "data"
//    }
//    fun finishedFetch(){
//        loadstate = Success(dataFetched)
//        dataFetched = null
//    }
//    fun error(){
//        loadstate = Error(exception = Exception("Exception.."))
//    }
//    fun getCurrentState(): Result {
//        return loadstate
//    }
//
//}

































//
////Enum & State
//
//fun main(){
//
////    val input = Result.ERROR
////    getResult(result = input)
//    Repository.startFetch()
//    getResult(Repository.getCurrentState())
//    Repository.finishedFetch()
//    getResult(Repository.getCurrentState())
//    Repository.error()
//    getResult(Repository.getCurrentState())
//
//
//}
//fun getResult(result: Result){
//    return when(result){
//        Result.SUCCESS -> println("Success!!!")
//        Result.ERROR -> println("ERRRRRR!++")
//        Result.IDLE -> println("Idle_-_")
//        Result.LOADING -> println("LOadin.g....")
//    }
//}
//
//
//
//
//
//enum class Result {
//    SUCCESS,          // SUCCESS(data: String)      //Limitation
//    ERROR,            //absctract class              //overcome
//    IDLE,
//    LOADING
//}
//
//object Repository {
//    private var loadstate: Result = Result.IDLE
//    private var dataFetched: String? = null
//
//    fun startFetch(){
//        loadstate = Result.LOADING
//        dataFetched = "data"
//    }
//    fun finishedFetch(){
//        loadstate = Result.SUCCESS
//        dataFetched = null
//    }
//    fun error(){
//        loadstate = Result.ERROR
//    }
//    fun getCurrentState(): Result {
//        return loadstate
//    }
//
//}

















package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random


fun main() = runBlocking {
    generateRandomNumbers(10).collect {
        println(it)
    }
    println("That's all folks!")
}


fun generateRandomNumbers(count: Int) = flow {
    for (i in 0 until count) {
        delay(1000)
        emit(Random.nextInt(1, 100))
    }
}.flowOn(Dispatchers.IO)

package flow_v2

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println("received ${randomPercentages(100, 200).first()}")
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun randomPercentages(count: Int, delayMs: Long) = flow {
    for (i in 0 until count) {
        delay(delayMs)
        val value = Random.nextInt(1, 100)
        println("emitting $value")
        emit(value)
    }
}
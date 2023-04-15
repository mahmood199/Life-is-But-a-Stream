package flow_v2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println("received ${flowOfRandomPercentages(100, 200).first()}")
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun flowOfRandomPercentages(count: Int, delayMs: Long) = flow {
    for (i in 0 until count) {
        delay(delayMs)
        val value = Random.nextInt(1, 100)
        println("emitting $value")
        emit(value)
    }
}
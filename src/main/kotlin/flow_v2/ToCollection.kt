package flow_v2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println(toCollectionRandomPercentages(10, 200).toList())
        println(toCollectionRandomPercentages(10, 200).toSet())
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun toCollectionRandomPercentages(count: Int, delayMs: Long) = flow {
    for (i in 0 until count) {
        delay(delayMs)
        emit(Random.nextInt(1, 100))
    }
}
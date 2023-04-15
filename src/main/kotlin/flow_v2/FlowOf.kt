package flow_v2

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        randomPercentages().collect { println(it) }
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun randomPercentages(): Flow<Int> {
    return flowOf(
        Random.nextInt(1, 100),
        Random.nextInt(1, 100),
        Random.nextInt(99, 100)
    )
}

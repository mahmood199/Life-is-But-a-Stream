package flow_v2.dispatchers

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        flow {
            for (i in 0 until 10) {
                delay(200)
                emit(Random.nextInt(1, 100))
            }
        }
            .flowOn(Dispatchers.Default)
            .collect { println(it) }

        println("That's all folks!")
    }

    println("...and we're off!")
}

/**
 *      the lambda expression will run on Dispatchers.Default,
 *      but our collection of the results will be performed
 *      on Dispatchers.Main (courtesy of the launch()dispatcher)
 */
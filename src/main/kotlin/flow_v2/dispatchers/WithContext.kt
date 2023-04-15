package flow_v2.dispatchers

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        flow {
            for (i in 0 until 10) {
                val random = withContext(Dispatchers.Default) {
                    delay(200)
                    Random.nextInt(1, 100)
                }
                emit(random)
            }
        }.collect { println(it) }
        println("That's all folks!")
    }
    println("...and we're off!")
}


package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun randomSharedFlow() = MutableSharedFlow<Int>(replay = 10).apply {
    runBlocking {
        for (i in 0 until 10) {
            delay(200)
            this@apply.emit(Random.nextInt(1, 100))
        }
    }
}

fun main() = runBlocking {
    val sharedFlow = randomSharedFlow()
    launch {
        sharedFlow.collect { println("Collector A: $it") }
    }
    launch {
        sharedFlow.collect { println("Collector B: $it") }
    }
    println("...and we're off!")
}
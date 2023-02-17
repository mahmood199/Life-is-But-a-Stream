package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlin.random.Random


fun randomSharedFlow1(): Flow<Int> {
    val sharedFlow = MutableSharedFlow<Int>()
    GlobalScope.launch(Dispatchers.Default) {
        for (i in 0 until 10) {
            delay(200)
            sharedFlow.emit(Random.nextInt(1,100))
        }
    }
    return sharedFlow
}

fun randomBufferSharedFlow(): Flow<Int> {
    val sharedFlow = MutableSharedFlow<Int>(replay = 2)
    GlobalScope.launch(Dispatchers.Default) {
        for (i in 0 until 10) {
            sharedFlow.emit(Random.nextInt(1, 100))
            delay(200)
        }
    }
    return sharedFlow
}

fun main() = runBlocking {
    val sharedFlow = randomBufferSharedFlow()
    launch {
        sharedFlow.collect { println("Collector A: $it") }
    }
    launch {
        delay(1000)
        sharedFlow.collect { println("Collector B: $it") }
    }
    println("...and we're off!")
}
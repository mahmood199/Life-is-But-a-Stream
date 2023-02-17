package flow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun randomStateFlow() = MutableStateFlow(1).apply {
    GlobalScope.launch {
        for (i in 0 until 5) {
            this@apply.emit(5)
            delay(200)
        }
    }
}

fun main() = runBlocking {
    val sharedFlow = randomStateFlow()
    launch {
        println(sharedFlow.toString())
        sharedFlow.collect { println("Collector A: $it") }
    }
    println("...and we're off!")
}
package channel.buffered

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

const val SOME_VALUE_BETWEEN_ONE_TO_INT_MAX = 12

fun main() {
    waysToInitialiseArrayChannel()
    demoForUsingArrayChannel()
}

fun waysToInitialiseArrayChannel() {
    val channel = Channel<Int>(SOME_VALUE_BETWEEN_ONE_TO_INT_MAX)
}

fun demoForUsingArrayChannel() = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>(SOME_VALUE_BETWEEN_ONE_TO_INT_MAX)
        val sender = launch {
            repeat(10) {
                channel.send(it)
                println("Sent $it")
            }
        }
        delay(500)
        println("Taking two")
        while (!channel.isEmpty) {
            val x = channel.receive()
            delay(1000)
            println("Received $x")
        }

    }
    println("Took $time ms")
}

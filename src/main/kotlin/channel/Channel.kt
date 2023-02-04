package channel

import javafx.application.Application.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/**
 * [Channels] allow concurrent code to communicate with each other
 * by sending and receiving messages between different coroutines.
 * These are basically pipelines
 */

fun main() {
    waysToInitialiseAnUnBufferedChannel()
    demoForUsingAnUnBufferedChannel()
}

fun waysToInitialiseAnUnBufferedChannel() {
    val rendezvousChannel1 = Channel<Int>()
    val rendezvousChannel2 = Channel<Int>(0)
}

fun demoForUsingAnUnBufferedChannel() = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>()
        GlobalScope.launch {
            repeat(10) {
                channel.send(it)
                println("Sent $it")
            }
        }
        channel.receive()
        channel.receive()
    }
    println("Took ${time}ms")
}






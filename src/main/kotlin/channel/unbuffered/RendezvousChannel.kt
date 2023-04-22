package channel.unbuffered

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

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
        launch {
            repeat(10) {
                channel.send(it)
                println("Sent $it")
            }
        }
        channel.receive()
        channel.receive()
/*
        Receives the emitted value as they are emitted in order
        channel.receiveAsFlow().collect {
            println("Received $it")
        }

*/
    }
    println("Took ${time}ms")
}






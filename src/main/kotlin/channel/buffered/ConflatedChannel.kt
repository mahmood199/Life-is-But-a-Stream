package channel.buffered

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    waysToInitialiseAConflatedChannel()
    demoForUsingAConflatedChannel()
}

fun waysToInitialiseAConflatedChannel() {
    val channel = Channel<Int>(Channel.CONFLATED)
}

fun demoForUsingAConflatedChannel() = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>(Channel.CONFLATED)
        launch {
            repeat(5) {
                channel.send(it)
                println("Sent $it")
            }
        }
        delay(500)
        val element = channel.receive()
        println("Received $element")
        println(channel.isEmpty)
        val element2 = channel.receive()
        println("Received $element2")
    }
    println("Took ${time}ms")
}

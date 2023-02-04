package channel.buffered

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    waysToInitialiseALinkedListChannel()
    demoForUsingALinkedListChannel()
}

fun waysToInitialiseALinkedListChannel() {
    val channel = Channel<Int>(Channel.UNLIMITED)
}

fun demoForUsingALinkedListChannel() = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>(Channel.UNLIMITED)
        GlobalScope.launch {
            repeat(10) {
                channel.send(it)
                println("Sent $it")
            }
        }
        delay(1000)
    }
    println("Took ${time}ms")
}

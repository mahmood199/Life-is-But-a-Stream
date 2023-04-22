package channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.receiveAsFlow

@OptIn(ObsoleteCoroutinesApi::class)
fun main() = runBlocking {
    val channel = BroadcastChannel<Int>(10)

    launch(Dispatchers.IO) {
        println("A: before receiving")
        channel.consumeEach { println("A: $it") }
        println("A: after receiving")
    }

    launch(Dispatchers.IO) {
        println("B: before receiving")
        channel.consumeEach { println("B: $it") }
        println("B: after receiving")
    }

    launch(Dispatchers.Default) {
        println("before first send")
        channel.send(123)
        println("before second send")
        channel.send(456)
        println("before third send")
        channel.send(789)
        println("before fourth send")
        channel.send(1234)
        println("before fifth send")
        channel.send(5678)
        println("after sending all")
        delay(100)
        channel.close()
    }

    println("...and we're off!")
}
//Ignore the to and fro in the order
package channel.receive

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

fun main() {
//    validatingBeforeReceivingElements()
    //receiveChannnel()
    justReceiveChannel()
}

fun validatingBeforeReceivingElements() {
    val channel = Channel<Int>()
    println(channel.isClosedForReceive) // false
    channel.close()
    println(channel.isClosedForReceive) // true
    //Below commented code will throw Channel was closed exception
    //because channel is closed before receiving items
    /*runBlocking {
        channel.receive()
    }*/
}

fun receiveChannnel() = runBlocking {
    val channel = Channel<Int>(Channel.BUFFERED)
    launch(Dispatchers.IO) {
        for (i in 0 until 10) {
            delay(200)
            channel.send(Random.nextInt(1,100))
        }
        channel.close()
    }
    //channel.poll is deprecated
    println(channel.tryReceive().getOrNull())
}

fun CoroutineScope.randomPercentagesWithDelay(count: Int, delayMs: Long) = produce {
    for (i in 0 until count) {
        delay(delayMs)
        send(Random.nextInt(1,100))
    }
}

fun justReceiveChannel()= runBlocking {
    launch(Dispatchers.IO) {
        println(randomPercentagesWithDelay(10, 200).receive())
        println("That's all folks!")
    }
    println("...and we're off!")
}

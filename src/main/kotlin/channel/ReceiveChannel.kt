package channel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
//    validatingBeforeReceivingElements()
    receiveByPoll()
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

fun receiveByPoll() = runBlocking {
    val channel = Channel<Int>(Channel.BUFFERED)
    launch(Dispatchers.IO) {
        for (i in 0 until 10) {
            delay(200)
            channel.send(Random.nextInt(1,100))
        }
        channel.close()
    }
    println(channel.tryReceive().getOrNull())
}

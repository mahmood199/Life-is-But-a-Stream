package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking

fun main() {
    validatingBeforeReceivingElements()
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

package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking

fun main() {
    validatingBeforeSendingElements()
    runBlocking {
        //Using send
        demoToThrowExceptionWhenElementsAreSentAfterChannelIsClosed()
        //Using Offer
        demoToThrowExceptionWhenElementsAreOfferedAfterChannelIsClosed()

    }
}

fun validatingBeforeSendingElements() {
    val channel = Channel<Int>()
    println(channel.isClosedForSend) // false
    channel.close()
    println(channel.isClosedForSend) // true
}

suspend fun demoToThrowExceptionWhenElementsAreSentAfterChannelIsClosed() {
    val channel = Channel<Int>(1)
    channel.close()
    channel.send(1)
}

fun demoToThrowExceptionWhenElementsAreOfferedAfterChannelIsClosed() {
    val channel = Channel<Int>(1)
    println("From offer function " + channel.trySend(10).isSuccess)
    channel.close()
    println("From offer function " + channel.trySend(10).isSuccess)
}



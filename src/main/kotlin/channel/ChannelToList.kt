package channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        /**
         *      toList() is a suspend function, like consumeEach(),
         *      and so needs to be called from inside of a coroutine.
         */
        println(randomPercentages(10, 200).toList())
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun CoroutineScope.randomPercentages(count: Int, delayMs: Long) = produce {
    for (i in 0 until count) {
        delay(delayMs)
        send(Random.nextInt(1, 100))
    }
}

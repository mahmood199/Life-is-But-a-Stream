package channel.receive

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println(randomPercentages(10, 200).toList())
        println("All the elements will be printed after the total delay. When all elements are generated")
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

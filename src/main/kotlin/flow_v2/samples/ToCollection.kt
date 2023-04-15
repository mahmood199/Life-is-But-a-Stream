package flow_v2.samples

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println(toCollectionRandomPercentages(10, 200).toList())
        println(toCollectionRandomPercentages(10, 200).toSet())
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun toCollectionRandomPercentages(count: Int, delayMs: Long) = flow {
    for (i in 0 until count) {
        delay(delayMs)
        emit(Random.nextInt(1, 100))
    }
}

/**
 *      These functions handle all bounded flows: zero items,
 *      one item, or several items. However, they only work
 *      for flows that will close themselves based on some
 *      internal criterion. These functions will not work
 *      well for flows that might emit objects indefinitely.
 */
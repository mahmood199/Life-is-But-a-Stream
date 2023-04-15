package flow_v2

import kotlinx.coroutines.flow.single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println(singleFlowRandomPercentage().single())
        println("That's all folks!")
    }

    println("...and we're off!")
}

fun singleFlowRandomPercentage() = flow {
    emit(Random.nextInt(1, 100))
    //  emit(Random.nextInt(1,10)) <--- this line will crash the flow
}
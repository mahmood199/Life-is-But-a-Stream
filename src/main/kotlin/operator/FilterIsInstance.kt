package operator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        flowOf(1, "two", 3, 4, "five", "six", 7, "eight", 9, "ten")
            .filterIsInstance<Int>()
            .collect {
                println(it)
            }
    }
}

/**
 *      filterIsInstance() filters based on type.
 *      You supply a type, and only upstream emissions
 *      that are of that type will be emitted downstream.
 */
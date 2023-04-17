package operator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .filter {
                it % 3 != 0
            }
            .collect { println(it) }
    }
}
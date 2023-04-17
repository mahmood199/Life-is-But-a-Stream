package operator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
            .dropWhile {
                it % 7 != 0
            }
            .collect { println(it) }
    }
}

/**
 *      dropWhile() skips all items until a supplied lambda
 *      expression (or other function type) returns true.
 *      Then, that item and all subsequent ones get emitted.
 */
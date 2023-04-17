package operator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        flowOf(1, null, 3, null, null, 6, null, 8, 9, null)
            .filterNotNull()
            .collect { println(it) }
    }
}
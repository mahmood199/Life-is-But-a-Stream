package operator

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(): Unit = runBlocking {
    launch(Dispatchers.IO) {
        bouncyBouncy()
            .debounce(250)
            .collect {
                println(it)
            }
    }
}

fun bouncyBouncy() = flow {
    listOf(
        50L,
        100L,
        200L,
        50L,
        400L
    ).forEachIndexed { i, delay ->
        delay(delay)
        emit(i)
    }
}
package callback_apis

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

fun stuffFlow() = callbackFlow<Int> {
    val watcher = object : StuffWatcher {
        override fun onStuff(s: Stuff) {
/*
            trySend(s).isSuccess
            send(s)
*/
        }
    }
    registerForStuff(watcher)
    awaitClose {
        unregisterForStuff(watcher)
    }
}

fun registerForStuff(watcher: StuffWatcher) {

}

fun unregisterForStuff(watcher: StuffWatcher) {

}

interface StuffWatcher {
    fun onStuff(s: Stuff)
}

data class Stuff(
    val someNumber: Int
)
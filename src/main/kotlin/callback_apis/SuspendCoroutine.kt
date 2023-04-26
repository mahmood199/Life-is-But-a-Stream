package callback_apis

import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun main() {

}

suspend fun doSomethingCoroutine() = suspendCoroutine { continuation ->
    doSomething(object : Something {
        override fun whenDone() {
            continuation.resume(Unit)
        }

    })
}

fun doSomething(any: Any) {

}

suspend fun doTheNextThingCoroutine(): List<String> =
    suspendCoroutine { continuation ->
        doTheNextThing(object : NextThing {
            override fun onSuccess(result: List<String>) {
                continuation.resume(result)
            }
            override fun onError(t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }

fun doTheNextThing(nextThing: NextThing) {

}


interface Something {
    fun whenDone()
}

interface NextThing {
    fun onSuccess(result: List<String>)
    fun onError(t: Throwable)
}

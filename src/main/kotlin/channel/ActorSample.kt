package channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.consumeEach
import java.util.*


class ActorSample {

    private val receivedItems: MutableList<Int> =
        Collections.synchronizedList(mutableListOf<Int>())

    fun actOut(scope: CoroutineScope) = scope.actor(Dispatchers.Default) {
        consumeEach {
            receivedItems.add(it)
        }
    }
}
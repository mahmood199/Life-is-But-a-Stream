package theading

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor

sealed class Action {
    object INCREASE : Action()
    object DECREASE : Action()
}


class Actor {

    private var counter = 0
    private val context = newSingleThreadContext("counterActor")
    fun getCounter() = counter
    lateinit var actorCounter : SendChannel<Action>
    var st = ArrayDeque<Pair<Int, Int>>()
    var smallestValue = Int.MIN_VALUE



    private fun CoroutineScope.initActor() = actor<Action>(capacity = 20) {
            for (msg in channel) {
                when (msg) {
                    Action.INCREASE -> counter++
                    Action.DECREASE -> counter--
                }
            }
        }


    private suspend fun asyncIncrement(by: Int) = CoroutineScope(context).async {
        for (i in 0 until by) {
            actorCounter.send(Action.INCREASE)
        }
    }

    private suspend fun asyncDecrement(by: Int)  =  CoroutineScope(context).async {
        for (i in 0 until by) {
            actorCounter.send(Action.DECREASE)
        }
    }

    fun main(args: Array<String>) = runBlocking {
        initActor().send(Action.DECREASE)
        val workerA = asyncIncrement(2000)
        val workerB = asyncIncrement(100)
        val workerC = asyncDecrement(1000)
        workerA.await()

        workerB.await()
        workerC.await()
        print("counter [${getCounter()}]")
    }


    fun push(value: Int) {
        st.push(Pair(value, smallestValue))
        smallestElement = if(smallestElement > value) value else smallestValue
    }

    fun pop() {
        val top = st.peek()
        st.pop()
        smallestElement = top.second
    }

    fun top(): Int {
        return st.peek().first
    }

    fun getMin(): Int {
        return smallestElement
    }
}


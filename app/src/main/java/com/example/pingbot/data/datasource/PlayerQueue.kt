package com.example.pingbot.data.datasource

import android.util.Log

data class PlayerQueue(
    private val queue: MutableList<User> = mutableListOf()
) {

    fun addPlayer(player: User) {
        queue.add(player)
    }


    fun callNextPlayer(isPlayer1: Boolean): User? {
        if (queue.size < 3) {
            Log.e("PlayerQueue", "Não há jogadores suficientes na fila.")
            return null
        }

        return if (isPlayer1) {
            val next = getThird()
            getFirst()?.also {
                queue.removeAt(0)
                queue.add(it)
            }
            next
        } else {
            val next = getThird()
            getSecond()?.also {
                queue.removeAt(1)
                queue.add(it)
            }
            next
        }
    }



    fun removePlayer(player: User): Boolean {
        return queue.remove(player)
    }


    fun getFirst(): User? {
        return queue.firstOrNull()
    }

    fun getSecond(): User? {
        return queue.getOrNull(1)
    }

    fun getThird(): User? {
        return queue.getOrNull(2)
    }


    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }


    fun size(): Int {
        return queue.size
    }


    fun clear() {
        queue.clear()
    }


    fun getAllPlayers(): List<User> {
        return queue.toList()
    }
}

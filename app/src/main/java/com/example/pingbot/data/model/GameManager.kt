package com.example.pingbot.data.model

import com.example.pingbot.data.datasource.Game
import com.example.pingbot.data.datasource.currentMatchMock
import com.example.pingbot.data.datasource.previousGamesList


class GameManager {
    private var previousGames: MutableList<Game> = mutableListOf()
    private var currentMatch: Game? = null


    fun addPreviousGame(game: Game) {
        previousGames.add(game)
    }


    fun getPreviousGames(): List<Game> {

        previousGamesList.previousGames.forEach { game ->
            previousGames.add(game)
        }

        return previousGames
    }


    fun setCurrentMatch(game: Game) {
        currentMatch = game
    }


    fun getCurrentMatch(): Game? {

        currentMatch = currentMatchMock

        return currentMatch
    }


    fun hasCurrentMatch(): Boolean {
        return currentMatch != null
    }


    fun clearCurrentMatch() {
        currentMatch = null
    }
}

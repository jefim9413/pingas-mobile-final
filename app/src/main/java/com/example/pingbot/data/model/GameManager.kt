package com.example.pingbot.data.model

import android.util.Log
import com.example.pingbot.data.datasource.Game
import com.example.pingbot.data.datasource.PlayerQueue
import com.example.pingbot.data.datasource.User
import com.example.pingbot.data.datasource.Users
import com.example.pingbot.data.datasource.currentMatchMock
import com.example.pingbot.data.datasource.previousGamesList


class GameManager {
    private var previousGames: MutableList<Game> = mutableListOf()
    private var currentMatch: Game = currentMatchMock

    private var playerQueue: PlayerQueue = PlayerQueue(Users)

    fun getCurrentMatch(): Game {
        if (playerQueue.size() >= 2) {
            currentMatch = Game(
                id = currentMatch.id + 1,
                player1 = playerQueue.getFirst()!!,
                player2 = playerQueue.getSecond()!!,
                score1 = 0,
                score2 = 0
            )
        } else {
            Log.e("GameManager", "Fila insuficiente para criar uma nova partida.")
        }
        return currentMatch
    }

    fun updateCurrentMatchPlayer(isPlayer1: Boolean): Game? {
        // Adicionar o jogo atual à lista de jogos anteriores
        addPreviousGame(currentMatch)

        // Verificar se há jogadores suficientes na fila
        val nextPlayer = if (isPlayer1) {
            playerQueue.callNextPlayer(true)
        } else {
            playerQueue.callNextPlayer(false)
        }

        // Garantir que há um próximo jogador
        if (nextPlayer == null) {
            Log.e("GameManager", "Não há jogadores suficientes na fila para atualizar a partida.")
            return null
        }

        // Criar o novo jogo com base no jogador atualizado
        currentMatch = if (isPlayer1) {
            Game(
                id = currentMatch.id + 1,
                player1 = nextPlayer,
                player2 = currentMatch.player2,
                score1 = 0,
                score2 = 0
            )
        } else {
            Game(
                id = currentMatch.id + 1,
                player1 = currentMatch.player1,
                player2 = nextPlayer,
                score1 = 0,
                score2 = 0
            )
        }

        return currentMatch
    }

    fun endWarmup(game: Game) {
        game.warmup = false
    }


    fun addPreviousGame(game: Game) {
        previousGames.add(game)
    }


    fun getPreviousGames(): List<Game> {

        previousGamesList.previousGames.forEach { game ->
            previousGames.add(game)
        }

        return previousGames
    }

    fun currentMatchWinner( winner: User ) {
        currentMatch.winner = winner
    }

}
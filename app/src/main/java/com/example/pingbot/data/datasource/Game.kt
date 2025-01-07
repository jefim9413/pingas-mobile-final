package com.example.pingbot.data.datasource

data class Game(
    val id: Int,
    val player1: User,
    val player2: User,
    val score1: Int,
    val score2: Int,
    val warmup: Boolean? = false,
    val winner: User? = null
)

val currentMatchMock = Game(
    id = 3,
    player1 = Users[0],
    player2 = Users[1],
    score1 = 4,
    score2 = 7
    )

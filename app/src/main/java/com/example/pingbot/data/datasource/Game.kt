package com.example.pingbot.data.datasource

data class Game(
    val id: Int,
    var player1: User,
    var player2: User,
    var score1: Int,
    var score2: Int,
    var warmup: Boolean? = false,
    var winner: User? = null
)

val currentMatchMock = Game(
    id = 3,
    player1 = Users[0],
    player2 = Users[1],
    score1 = 4,
    score2 = 7
    )


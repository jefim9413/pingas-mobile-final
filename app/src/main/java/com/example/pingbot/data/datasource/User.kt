package com.example.pingbot.data.datasource

import com.example.pingbot.R

data class User(
    val id: Int,
    val name: String,
    val mail: String,
    val profileImage: Any,
    val points: Int? = 0,
    val wins: Int? = 0,
    val losses: Int? = 0,
    val admin: Boolean? = false,
    val Style: String? = null,
    val winPercentage: Float? =
        if (wins != null && losses != null) {
            (wins.toFloat() / (wins + losses).toFloat()) * 100
        } else {
            0f
        }
)

val Users = listOf(
    User(id = 1, name = "Alice", mail = "okay", profileImage = R.drawable.img_2, wins = 10, losses = 2),
    User(id = 2, name = "Bob", mail = "okay", profileImage = R.drawable.img_3, wins = 2, losses = 5 ),
    User(id = 3, name = "Terry", mail = "okay", profileImage = R.drawable.img_3, wins = 30, losses = 21 ),
)




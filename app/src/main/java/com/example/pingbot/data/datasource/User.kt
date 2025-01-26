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

val Users = mutableListOf(
    User(id = 1, name = "Alice", mail = "alice@example.com", profileImage = R.drawable.img_2, wins = 10, losses = 2),
    User(id = 2, name = "Bob", mail = "bob@example.com", profileImage = R.drawable.img_3, wins = 2, losses = 5),
    User(id = 3, name = "Terry", mail = "terry@example.com", profileImage = R.drawable.img_3, wins = 30, losses = 21),
    User(id = 4, name = "Jane", mail = "jane@example.com", profileImage = R.drawable.img_2, wins = 15, losses = 10),
    User(id = 5, name = "Mark", mail = "mark@example.com", profileImage = R.drawable.img_3, wins = 8, losses = 12),
    User(id = 6, name = "Sophia", mail = "sophia@example.com", profileImage = R.drawable.img_2, wins = 22, losses = 9),
    User(id = 7, name = "Lucas", mail = "lucas@example.com", profileImage = R.drawable.img_3, wins = 14, losses = 11),
    User(id = 8, name = "Emma", mail = "emma@example.com", profileImage = R.drawable.img_2, wins = 18, losses = 5),
    User(id = 9, name = "Oliver", mail = "oliver@example.com", profileImage = R.drawable.img_3, wins = 5, losses = 15),
    User(id = 10, name = "Mia", mail = "mia@example.com", profileImage = R.drawable.img_2, wins = 25, losses = 3)
)




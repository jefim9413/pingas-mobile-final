package com.example.pingbot.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pingbot.data.datasource.Game
import com.example.pingbot.data.datasource.Users
import com.example.pingbot.ui.theme.Digital


@Composable
fun GameScore(game: Game) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // Placar dos jogadores
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
            ) {

                PlayerProfile(
                    game.player1,
                    120,
                    modifier = Modifier
                        .clickable {
                        }
                    )
                Text(
                    text = "VS",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                PlayerProfile(
                    game.player2,
                    120,
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {

            Text(
                text = "${game.score1} - ${game.score2}",
                color = Color.White,
                fontFamily = Digital,
                fontSize = 94.sp,
            )

        }
    }
}
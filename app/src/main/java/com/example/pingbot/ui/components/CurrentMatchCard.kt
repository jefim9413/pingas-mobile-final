package com.example.pingbot.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.pingbot.data.datasource.Game

@Composable
fun CurrentMatch(game: Game, navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { showDialog = true },
        colors = CardDefaults.cardColors(containerColor = Color.Blue),
        border = BorderStroke(
            width = 3.dp,
            color = Color.White
        )
    ) {

        Column(
            modifier = Modifier
                .heightIn(20.dp)
                .padding(0.dp)
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PlayerProfile(game.player1, 150)

                VerticalDividerComp(
                    thickness = 6.dp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(0.dp)

                )

                PlayerProfile(game.player2, 150)
            }
        }
    }


    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            PlayerProfile(game.player1, 50)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "% de vitórias: ",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,

                                )

                            Text(
                                text = " ${game.player1.winPercentage} ",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,

                                )
                        }


                        Text(
                            text = "${game.score1} - ${game.score2}",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 20.sp
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            PlayerProfile(game.player2, 50)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "% de vitórias: ",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,

                                )

                            Text(
                                text = " ${game.player2.winPercentage} ",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,

                                )
                        }
                    }
                }
            }
        }
    }
}

    @Composable
    fun VerticalDividerComp(
        modifier: Modifier = Modifier,
        thickness: Dp = 1.dp
    ) {
        Box(
            modifier
                .heightIn(250.dp)
                .width(thickness)
                .background(color = Color.White)
        )
    }

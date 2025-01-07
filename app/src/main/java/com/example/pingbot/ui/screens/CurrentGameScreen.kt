package com.example.pingbot.ui.screens

import TopAppBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.data.model.GameManager
import com.example.pingbot.ui.components.CurrentMatch
import com.example.pingbot.ui.components.DrawerMenu
import kotlinx.coroutines.launch

@Composable
fun CurrentGameScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val manager = GameManager()
    val game = manager.getCurrentMatch()

    val player1Score = remember { mutableStateOf(game?.score1 ?: 0) }
    val player2Score = remember { mutableStateOf(game?.score2 ?: 0) }
    val isWarmUpActive = remember { mutableStateOf(false) }

    DrawerMenu(
        navController = navController,
        scope = scope,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navController = navController,
                    onOpenDrawer = { scope.launch { drawerState.open() } },
                    showBackButton = true
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFEAEAEA))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Gerenciar Jogo",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3D66CC),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                if (game != null) {
                    CurrentMatch(game = game, navController = navController)

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            isWarmUpActive.value = !isWarmUpActive.value
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isWarmUpActive.value) Color.Red else MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = if (isWarmUpActive.value) "Parar Aquecimento" else "Iniciar Aquecimento")
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = game.player1.name, style = MaterialTheme.typography.bodyLarge)

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(onClick = { if (player1Score.value > 0) player1Score.value -= 1 }) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Diminuir Pontos Jogador 1"
                                    )
                                }
                                Text(
                                    text = "${player1Score.value}",
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                IconButton(onClick = { player1Score.value += 1 }) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Aumentar Pontos Jogador 1"
                                    )
                                }
                            }
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = game.player2.name, style = MaterialTheme.typography.bodyLarge)

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(onClick = { if (player2Score.value > 0) player2Score.value -= 1 }) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "Diminuir Pontos Jogador 2"
                                    )
                                }
                                Text(
                                    text = "${player2Score.value}",
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                IconButton(onClick = { player2Score.value += 1 }) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Aumentar Pontos Jogador 2"
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            navController.navigate("endGameScreen")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text(text = "Encerrar Partida")
                    }
                } else {
                    Text(
                        text = "Informações do jogo não disponíveis",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}



package com.example.pingbot.ui.screens

import TopAppBar
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.R
import com.example.pingbot.data.datasource.Game
import com.example.pingbot.data.model.GameManager
import com.example.pingbot.ui.components.BottomBar
import com.example.pingbot.ui.components.DrawerMenu
import com.example.pingbot.ui.components.GameScore
import com.example.pingbot.ui.theme.BackgroundColor
import com.example.pingbot.utils.sendNotificationToPlayers
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val gameManager = GameManager()

    val isLoading = remember { mutableStateOf(true) }
    val gameState = remember { mutableStateOf<Game?>(null) }



    val currentMatch = gameManager.getCurrentMatch()
    gameState.value = currentMatch


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
                    showBackButton = false
                )
            },
            bottomBar = { BottomBar(navController) }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(BackgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Exibe os dados do jogo atual
                    gameState.value.let { game ->
                        if (game != null) {
                            GameScore(game)
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = "Logo Horizontal",
                        modifier = Modifier.size(300.dp)
                    )

                    Button(
                        onClick = {

                            val updatedGame = gameManager.updateCurrentMatchPlayer(
                                isPlayer1 = true
                            )

                            if (updatedGame != null) {
                                sendNotificationToPlayers(
                                    context = context,
                                    oldGame = currentMatch,
                                    newGame = updatedGame
                                )
                            }

                            gameState.value = updatedGame


                            Log.d(
                                "HomeScreen",
                                "Jogando: ${gameState.value?.player1?.name} e ${gameState.value?.player2?.name}"
                            )
                        },
                        modifier = Modifier.padding(top = 4.dp),
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Text(text = "Trocar Player", color = Color.White)
                    }
                }
            }
        }
    }
}





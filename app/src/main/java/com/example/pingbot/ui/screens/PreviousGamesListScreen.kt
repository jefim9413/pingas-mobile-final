package com.example.pingbot.ui.screens

import TopAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.data.model.GameManager
import com.example.pingbot.ui.components.DrawerMenu
import com.example.pingbot.ui.components.GameList
import com.example.pingbot.ui.theme.BackgroundColor
import kotlinx.coroutines.launch

@Composable
fun PreviousGamesListScreen(
    navController: NavHostController
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val gameManager = GameManager()

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
            containerColor = BackgroundColor
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                Text(
                    text = "Jogos Anteriores",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )

                GameList(gameManager.getPreviousGames(), navController)
            }
        }
    }
}

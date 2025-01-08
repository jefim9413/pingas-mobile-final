package com.example.pingbot.ui.screens
import TopAppBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.pingbot.R
import com.example.pingbot.data.datasource.Game
import com.example.pingbot.data.datasource.previousGamesList
import com.example.pingbot.ui.components.BottomBar
import com.example.pingbot.ui.components.DrawerMenu
import com.example.pingbot.ui.components.GameScore
import com.example.pingbot.ui.theme.Digital
import kotlinx.coroutines.launch

@Composable
fun GamesListScreen( navController: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    DrawerMenu(
        navController = navController,
        scope = scope,
        drawerState = drawerState
    )
    {
        Scaffold(
            topBar = {
                TopAppBar(
                    navController = navController,
                    onOpenDrawer = { scope.launch { drawerState.open() } },
                    showBackButton = false
                )
            },

            bottomBar = {
                BottomBar(navController)
            }

        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = Color(0xFF03A9F4)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items( previousGamesList.previousGames) { game ->
                            GameCard(game, navController)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun GameCard(game: Game, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = Color(0xFF0288D1)),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        onClick = {
            navController.navigate("PreviousGameDetails/${game.id}")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = game.player1.profileImage,
                    contentDescription = "${game.player1.name} avatar",
                    modifier = Modifier.size(50.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = game.player1.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Text(
                text = "${game.score1} - ${game.score2}",
                color = Color.White,
                fontFamily = Digital,
                fontSize = 60.sp,
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = game.player2.profileImage,
                    contentDescription = "${game.player2.name} avatar",
                    modifier = Modifier.size(50.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = game.player2.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}




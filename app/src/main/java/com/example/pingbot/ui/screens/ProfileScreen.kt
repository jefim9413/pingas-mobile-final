package com.example.pingbot.ui.screens

import TopAppBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.R
import com.example.pingbot.data.datasource.Users
import com.example.pingbot.ui.components.DrawerMenu
import com.example.pingbot.ui.theme.BackgroundColor
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    navController: NavHostController,
    onEditProfile: (() -> Unit)? = null
) {
    var name by remember { mutableStateOf("Seu Nome") }
    var age by remember { mutableStateOf("sua idade") }
    var course by remember { mutableStateOf("Seu curso") }
    var playStyle by remember { mutableStateOf("Caneta ou Classica") }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
            },
            containerColor = BackgroundColor
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_2),
                            contentDescription = "Foto de Perfil",
                            modifier = Modifier
                                .size(200.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))


                    TextField(
                        value = Users[0].name,
                        onValueChange = { name = it },
                        label = { Text("Nome") },
                        singleLine = true,
                        modifier = Modifier
                            .width(380.dp)
                            .background(
                                color = BackgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                                RoundedCornerShape(8.dp)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    TextField(
                        value = "20",
                        onValueChange = { age = it },
                        label = { Text("Idade") },
                        singleLine = true,
                        modifier = Modifier
                            .width(380.dp)
                            .background(
                                color = BackgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                                RoundedCornerShape(8.dp)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    TextField(
                        value = "Es",
                        onValueChange = { course = it },
                        label = { Text("Curso") },
                        singleLine = true,
                        modifier = Modifier
                            .width(380.dp)
                            .background(
                                color = BackgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                                RoundedCornerShape(8.dp)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    TextField(
                        value = "Caneta",
                        onValueChange = { playStyle = it },
                        label = { Text("Estilo de Jogo") },
                        singleLine = true,
                        modifier = Modifier
                            .width(380.dp)
                            .background(
                                color = BackgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                                RoundedCornerShape(8.dp)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))


                    TextButton(onClick = { onEditProfile?.invoke() }) {
                        Text(
                            text = "Analytics",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}


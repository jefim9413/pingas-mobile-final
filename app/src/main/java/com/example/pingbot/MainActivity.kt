package com.example.pingbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.pingbot.data.model.GameManager
import com.example.pingbot.navigation.AppNavigation
import com.example.pingbot.ui.screens.HomeScreen
import com.example.pingbot.ui.theme.PingBotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()


            PingBotTheme {
                AppNavigation(
                    navController = navController,
                )

            }
        }
    }
}
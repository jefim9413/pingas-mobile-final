package com.example.pingbot.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pingbot.data.datasource.previousGamesList
import com.example.pingbot.ui.screens.AnalyticsScreen
import com.example.pingbot.ui.screens.CurrentGameScreen
import com.example.pingbot.ui.screens.FaqScreen
import com.example.pingbot.ui.screens.GamesListScreen
import com.example.pingbot.ui.screens.HomeScreen
import com.example.pingbot.ui.screens.LoginScreen
import com.example.pingbot.ui.screens.PreviousGameDetailsScreen
import com.example.pingbot.ui.screens.PreviousGamesListScreen
import com.example.pingbot.ui.screens.ProfileScreen
import com.example.pingbot.ui.screens.QueueUsersScreen
import com.example.pingbot.ui.screens.RegisterScreen


@Composable
fun AppNavigation (
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable(route = "previousGames") {
            PreviousGamesListScreen(
                navController = navController
            )
        }

        composable(
            route = "home",
            enterTransition = { slideInHorizontally(tween(500)) },
            exitTransition = { slideOutHorizontally(tween(500)) }
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = "current",
            enterTransition = { fadeIn(tween(500)) },
            exitTransition = { fadeOut(tween(500)) }) {
            CurrentGameScreen(
                navController = navController
            )
        }

        composable(
            route = "faq",
            enterTransition = { fadeIn(tween(500)) },
            exitTransition = { fadeOut(tween(500)) }) {
            FaqScreen(
                navController = navController
            )
        }

        composable(route = "login") {
            LoginScreen(
                navController = navController
            )
        }

        composable(route = "analytics") {
            AnalyticsScreen(
                navController = navController
            )
        }

        composable(route = "Register") {
            RegisterScreen(
                navController = navController
            )
        }

        composable(route = "profile") {
            ProfileScreen(
                navController = navController
            )
        }
        composable(
            route = "gamesList",
            enterTransition = { slideInHorizontally(tween(500)) },
            exitTransition = { slideOutHorizontally(tween(500)) }) {
            GamesListScreen(
                navController = navController
            )
        }
        composable(
            route = "queueUsers",
            enterTransition = { slideInHorizontally(tween(500)) },
            exitTransition = { slideOutHorizontally(tween(500)) }
        ) {
            QueueUsersScreen(
                navController = navController
            )
        }

        composable(
            route = "previousGameDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("id") ?: 0
            val game = previousGamesList.previousGames.find { it.id == gameId }
            PreviousGameDetailsScreen(game = game, navController = navController)
        }

    }
}
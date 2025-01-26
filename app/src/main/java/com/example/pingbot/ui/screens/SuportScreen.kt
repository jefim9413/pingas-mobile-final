package com.example.pingbot.ui.screens

import TopAppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.ui.components.DrawerMenu
import com.example.pingbot.ui.components.QuestionItem
import com.example.pingbot.ui.theme.BackgroundColor
import kotlinx.coroutines.launch

@Composable
fun FaqScreen(navController: NavHostController) {
    val questionsAndAnswers = listOf(
        "Como me registro no aplicativo?" to "Para se registrar, clique no botão de cadastro na tela inicial e preencha suas informações.",
        "Como posso resetar minha senha?" to "Na tela de login, clique em 'Esqueceu a senha?' e siga as instruções.",
        "Como entrar em contato com o suporte?" to "acesse o canal no Telegram: https://t.me/+FRedt4B6YXViNmUx"
    )

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
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(
                        text = "Perguntas Frequentes",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.White
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    ) {
                        items(questionsAndAnswers) { (question, answer) ->
                            QuestionItem(question, answer)
                        }
                    }
                }
            }
        }
    }
}

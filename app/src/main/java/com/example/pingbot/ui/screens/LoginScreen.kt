package com.example.pingbot.ui.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pingbot.R
import com.example.pingbot.ui.theme.PrimaryColor

@Composable
fun LoginScreen(
    navController: NavHostController,
    onLogin: ((String, String) -> Unit?)? = null
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val isValidForm = email.isNotEmpty() && password.isNotEmpty()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fundo com imagem desfocada
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 4.dp),
            contentScale = ContentScale.Crop
        )

        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(350.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de e-mail
            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "E-mail",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .width(380.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 1f),
                        RoundedCornerShape(8.dp)
                    ),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent
                )
            )

            // Campo de senha
            TextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        "Senha",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .width(380.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 1f),
                        RoundedCornerShape(8.dp)
                    ),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    TextButton(onClick = { passwordVisible = !passwordVisible }) {
                        val iconText = if (passwordVisible) "Ocultar" else "Mostrar"
                        Text(iconText, color = Color.White)
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão de Entrar
            Button(
                onClick = {
                    if (isValidForm) {
                        isLoading = true
                        navController.navigate("home")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(50.dp),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = Color.White
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Text(text = "Entrar", fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botão de Registro
            TextButton(onClick = {
                navController.navigate("register")
            }) {
                Text(
                    text = "Ainda não tem uma conta? Registre-se",
                    color = Color.White,
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight
                )
            }
        }
    }
}

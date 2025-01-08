package com.example.pingbot.ui.screens

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.ui.theme.BackgroundColor
import com.example.pingbot.ui.theme.SecondaryColor

@Composable
fun RegisterScreen(
    navController: NavHostController,
    onRegister: ((String, String, String, String) -> Unit?)? = null,
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var matriculaOrSiape by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val isValidForm =
        name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword

    Scaffold(
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
                Text(
                    text = "Cadastre-se",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 32.dp),
                    color = Color.White
                )

                // Nome
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Seu Nome", color = Color.White) },
                    singleLine = true,
                    modifier = Modifier
                        .width(380.dp)
                        .background(color = BackgroundColor, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                        .border(1.dp, Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // E-mail
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail", color = Color.White) },
                    singleLine = true,
                    modifier = Modifier
                        .width(380.dp)
                        .background(color = BackgroundColor, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                        .border(1.dp, Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Senha
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha", color = Color.White) },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        TextButton(onClick = { passwordVisible = !passwordVisible }) {
                            Text(
                                if (passwordVisible) "Ocultar" else "Mostrar",
                                color = Color.White
                            )
                        }
                    },
                    modifier = Modifier
                        .width(380.dp)
                        .background(color = BackgroundColor, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                        .border(1.dp, Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Confirmar senha
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirmar Senha", color = Color.White) },
                    singleLine = true,
                    visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        TextButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                            Text(
                                if (confirmPasswordVisible) "Ocultar" else "Mostrar",
                                color = Color.White
                            )
                        }
                    },
                    modifier = Modifier
                        .width(380.dp)
                        .background(color = BackgroundColor, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                        .border(1.dp, Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                // Aviso de senhas não coincidentes
                if (password.isNotEmpty() && confirmPassword.isNotEmpty() && password != confirmPassword) {
                    Text(
                        text = "As senhas não coincidem",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Matrícula ou SIAPE
                TextField(
                    value = matriculaOrSiape,
                    onValueChange = { matriculaOrSiape = it },
                    label = { Text("Matrícula ou SIAPE", color = Color.White) },
                    singleLine = true,
                    modifier = Modifier
                        .width(380.dp)
                        .background(color = BackgroundColor, shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                        .border(1.dp, Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Botão de Criar Conta
                Button(
                    onClick = {
                        if (isValidForm) {
                            isLoading = true
                            if (onRegister != null) {
                                onRegister(name, email, password, confirmPassword)
                            }
                            navController.navigate("home")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(56.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = SecondaryColor
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(modifier = Modifier.size(24.dp))
                    } else {
                        Text(text = "Criar Conta", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botão de Login
                TextButton(onClick = {
                    navController.navigate("login")
                }) {
                    Text("Já possui uma conta? Login", color = Color.White)
                }
            }
        }
    }
}

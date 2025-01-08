package com.example.pingbot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pingbot.data.datasource.User

@Composable
fun PlayerInfo (player: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = player.profileImage,
            contentDescription = "Imagem de ${player.name}",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = player.name,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Vitórias: ${ player.wins }",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Derrotas: ${ player.losses }",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "% de vitorias: ${ player.winPercentage }",
            style = MaterialTheme.typography.bodyMedium
        )




    }
}
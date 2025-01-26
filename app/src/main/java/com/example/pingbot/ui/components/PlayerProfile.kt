package com.example.pingbot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pingbot.data.datasource.User


@Composable
fun PlayerProfile(
    player: User,
    size : Int? = 50,
    showName: Boolean? = true,
    modifier: Modifier? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (size != null) {
            AsyncImage(
                model = player.profileImage,
                contentDescription = "Imagem de ${player.name}",
                modifier = Modifier
                    .size(size.dp)
                    .clickable {
                    }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (showName == true) {
            Text(
                text = player.name,
                fontSize = 24.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

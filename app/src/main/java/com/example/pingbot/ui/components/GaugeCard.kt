package com.example.pingbot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pingbot.ui.theme.BackgroundColor
import com.example.pingbot.ui.theme.SecondaryColor

@Composable
fun GaugeCard(
    percentage: Float?,
    victories: Int,
    defeats: Int

) {
    val victoryPercentage = if (victories + defeats > 0) (victories.toFloat() / victories + defeats.toFloat()) * 100 else 0f

    Card(
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = SecondaryColor
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Vitórias",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 8.dp),
                color = Color.White
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(120.dp)
                    .background(SecondaryColor, shape = CircleShape)
            ) {
                GaugeChart(
                    percentage = percentage,
                    victories = victories,
                    defeats = defeats
                )

                Text(
                    text = "${percentage.toString().take(4) }%",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))
            )

            Text(
                text = "${victories} vitórias",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )

            Text(
                text = "${defeats} derrotas",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}
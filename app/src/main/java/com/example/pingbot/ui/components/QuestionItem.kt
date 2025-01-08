package com.example.pingbot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pingbot.ui.theme.BackgroundColor

@Composable
fun QuestionItem(question: String, answer: String) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = BackgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { expanded = !expanded }
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)

    ) {

        Row (
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                tint = if (expanded) Color.Black else MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.6f
                ),
            )

            Spacer(
                modifier = Modifier.padding(24.dp)
            )

            Text(
                text = question,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if (expanded) {
            Text(
                text = answer,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
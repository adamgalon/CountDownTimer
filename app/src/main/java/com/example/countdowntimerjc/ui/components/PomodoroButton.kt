package com.example.countdowntimerjc.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PomodoroButton(
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    text: String, clickEvent: () -> Unit
) {
    Button(
        enabled = enabled,
        onClick = clickEvent,
        modifier = Modifier
            .padding(3.dp)
            .width(170.dp),
    ) {
        Text(text = text)
    }
}
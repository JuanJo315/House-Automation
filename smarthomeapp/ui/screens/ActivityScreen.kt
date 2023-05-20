package com.example.smarthomeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme

@Composable
fun ActivityScreen() {
    LazyColumn(
        modifier = Modifier.padding(top = 20.dp, bottom = 12.dp).fillMaxWidth()
    ) {
        item {
            ActivityScreenCards()
        }
    }
}

@Composable
fun ActivityScreenCards() {
    Card() {
        Column() {
            Text(text = "Lights have been switched")
            Text(text = "Current State: On")
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Card() {
        Column() {
            Text(text = "Temperature and Humidity has been measured")
            Text(text = "Last Temperature Data: 11º")
            Text(text = "Last Humidity Data: 20%")
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Card() {
        Column() {
            Text(text = "Chatbot has been used")
            Text(text = "Last Message: Bye")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ActivityScreenPreview() {
    SmartHomeAppTheme {
        ActivityScreen()
    }
}
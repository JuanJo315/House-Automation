package com.example.smarthomeapp.ui.data

data class HomeUiState (
    val currentLightState: Boolean = false,
    val currentTemperature: Int = 0,
    val currentHumidity: Int = 0,
    val chatBotUsed: Boolean = false,
    val lastChatText: String = ""
)
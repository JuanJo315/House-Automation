package com.example.smarthomeapp.ui.data

import android.service.autofill.UserData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SmartHomeViewModel : ViewModel() {

    //private val _uiState = MutableStateFlow(HomeUiState())

    //val uiState: StateFlow<HomeUiState> =_uiState.asStateFlow()

    private val _uiState = MutableStateFlow(User)

    val uiState: StateFlow<User> =_uiState.asStateFlow()
}
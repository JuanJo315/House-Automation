package com.example.signscreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(User)

    val uiState: StateFlow<User> =_uiState.asStateFlow()

}
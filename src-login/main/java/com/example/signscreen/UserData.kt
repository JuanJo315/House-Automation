package com.example.signscreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
//import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserData(
    //viewModel: ViewModel = viewModel()
) {
    Text(text = User.name)
    //Text(text = User().name)
    //Text(text = viewModel.account)
}

/*
        @Composable
fun UserData(
    //viewModel: ViewModel = viewModel()
) {
    Column {
        //Text(text = User.name)
        Text(text = User().name)
        //Text(text = viewModel.account)
    }
    //Text(text = User.name)
    //Text(text = User().name)
    //Text(text = viewModel.account)
}

 */
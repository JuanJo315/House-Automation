package com.example.signscreen.originals

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

/**enum class SmartHomeScreen(val title: String) {
    LogIn(title = "Log In"),
    SignUp(title = "Sign Up"),
    WellDone(title = "Well Done"),
    UserData(title = "User Data")
}

@Composable
fun OriginalSmartHomeBar(
    currentScreen: SmartHomeScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(currentScreen.title) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        }
    )
}

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    viewModel: OriginalViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = SmartHomeScreen.valueOf(
        backStackEntry?.destination?.route ?: SmartHomeScreen.LogIn.name
    )

    Scaffold(
        topBar = {
            OriginalSmartHomeBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {
            innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = SmartHomeScreen.LogIn.name,
            modifier = modifier.padding(innerPadding)
        ) {

            composable(route = SmartHomeScreen.LogIn.name) {
                OriginalLogInScreen(
                    onLogInButtonClicked = {
                        navController.navigate(SmartHomeScreen.WellDone.name)
                    },
                    onSignUpButtonClicked = {
                        navController.navigate(SmartHomeScreen.SignUp.name)
                    }
                )
            }

            composable(route = SmartHomeScreen.SignUp.name) {
                OriginalSignUpScreen(
                    onLogInButtonClicked = {
                        navController.navigate(SmartHomeScreen.LogIn.name)
                    },
                    onSignUpButtonClicked = {
                        navController.navigate(SmartHomeScreen.WellDone.name)
                    }
                )
            }

            composable(route = SmartHomeScreen.WellDone.name) {
                OriginalWellDone(
                    onUserDataButtonClicked = {
                        //viewModel.setName(it)
                        navController.navigate(SmartHomeScreen.UserData.name)
                    }
                )
            }

            composable(route = SmartHomeScreen.UserData.name) {
                OriginalUserData()
            }
        }

    }
}
        */
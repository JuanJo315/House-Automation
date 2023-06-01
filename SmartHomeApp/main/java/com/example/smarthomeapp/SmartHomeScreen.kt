package com.example.smarthomeapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarthomeapp.ui.data.SmartHomeViewModel
import com.example.smarthomeapp.ui.screens.*

enum class SmartHomeScreen(@StringRes val title: Int) {
    //Welcome(title = R.string.welcome_screen),
    LogIn(title= R.string.login),
    SignUp(title = R.string.signup),
    Menu(title = R.string.menu),
    Lights(title = R.string.illumination),
    Ambiance(title = R.string.ambiance),
    //ChatBot(title = R.string.chat_bot_screen),
    Activity(title = R.string.activity_log)
}

@Composable
fun SmartHomeBar(
    currentScreen: SmartHomeScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun SmartHomeApp(
    modifier: Modifier = Modifier,
    smartHomeViewModel: SmartHomeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = SmartHomeScreen.valueOf(
        backStackEntry?.destination?.route ?: SmartHomeScreen.Menu.name
    )

    Scaffold(
        topBar = {
            SmartHomeBar(
                currentScreen = currentScreen,
                // We check there is a screen behind the current screen
                canNavigateBack = navController.previousBackStackEntry != null,
                // To navigate back to the previous screen
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {
            innerPadding ->
        val uiState by smartHomeViewModel.uiState.collectAsState()

        //val homeUiState by smartHomeViewModel.uiState.collectAsState()
        //innerPadding -> val uiState by viewModel.uiState.collectAsState()
        //contentPadding -> Box(modifier = Modifier.padding(contentPadding)) {}

        NavHost(
            navController = navController,
            startDestination = SmartHomeScreen.LogIn.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = SmartHomeScreen.Menu.name) {
                MenuScreen(
                    onLightsButtonClicked = {
                        navController.navigate(SmartHomeScreen.Lights.name)
                    },

                    onAmbianceButtonClicked = {
                        navController.navigate(SmartHomeScreen.Ambiance.name)
                    },

                    onActivityButtonClicked = {
                        navController.navigate(SmartHomeScreen.Activity.name)
                    }
                )
            }

            composable(route = SmartHomeScreen.Lights.name) {
                LightScreen()
            }

            composable(route = SmartHomeScreen.Ambiance.name) {
                AmbianceScreen()
            }

            composable(route = SmartHomeScreen.Activity.name) {
                ActivityScreen()
            }

            composable(route = SmartHomeScreen.LogIn.name) {
                LogInScreen(
                    onLogInButtonClicked = {
                        navController.navigate(SmartHomeScreen.Menu.name)
                    },
                    onSignUpButtonClicked = {
                        navController.navigate(SmartHomeScreen.SignUp.name)
                    }
                )
            }

            composable(route = SmartHomeScreen.SignUp.name) {
                SignUpScreen(
                    onSignUpButtonClicked = {
                        navController.navigate(SmartHomeScreen.Menu.name)
                    },
                    onLogInButtonClicked = {
                        navController.navigate(SmartHomeScreen.LogIn.name)
                    }
                )
            }
        }

    }
}
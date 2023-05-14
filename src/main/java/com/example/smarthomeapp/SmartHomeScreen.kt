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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarthomeapp.ui.data.SmartHomeViewModel
import com.example.smarthomeapp.ui.screens.LightScreen
import com.example.smarthomeapp.ui.screens.MenuScreen
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme

enum class SmartHomeScreen(@StringRes val title: Int) {
    Welcome(title = R.string.welcome_screen),
    Password(title = R.string.password),
    Menu(title = R.string.menu),
    Lights(title = R.string.illumination),
    Ambiance(title = R.string.ambiance),
    Chatbot(title = R.string.chat_bot_screen),
    Log(title = R.string.activity_log)
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
            startDestination = SmartHomeScreen.Menu.name,
            modifier = modifier.padding(innerPadding)
        ) {
            // The navigate method takes a single parameter: a string corresponding to a route
            // defined in your NavHost. If the route matches one of the calls to composable() in
            // the NavHost, the app then navigates to that screen.

            // Method composable is used to display a composable for a given route
            composable(route = SmartHomeScreen.Menu.name) {
                MenuScreen(
                    // A function calls navigate when the user clicks buttons on the start screen
                    onLightsButtonClicked = {
                        // Now when clicked the screen changes to the flavor screen
                        navController.navigate(SmartHomeScreen.Lights.name)
                    }
                )
            }

            composable(route = SmartHomeScreen.Lights.name) {
                LightScreen()
            }
        }

    }
}
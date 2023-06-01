package com.example.smarthomeapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SmartHomeScreenNavigationTest {
    // In tests, we don't have access to the navController of the app so we use
    // a test one and configure its rule
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    // To make sure that your app navigates to the correct place, you need to reference a
    // TestNavHostController instance to check the navigation route of the nav host when the app takes actions to navigate.
    private lateinit var navController: TestNavHostController


    @Before
    fun setupSmartHomeNavHost() {
        composeTestRule.setContent {

            /*// You now need to create the TestNavHostController object in the test class.
            // You use this object later to determine the navigation state, as the app uses
            // the controller to navigate the various screens in the Cupcake app.
            navController =
                TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )

            CupcakeApp(navController = navController)*/

            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            SmartHomeApp(navController = navController)
        }
    }


    // Test to confirm the start destination is the Password Screen
    @Test
    fun smartHomeNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(SmartHomeScreen.LogIn.name)
    }


    // Test to confirm the Password screen doesn't have an Up Button
    @Test
    fun smartHomeNavHost_verifyBackNavigationNotShownOnPasswordScreen() {
        // In the app, the Up button has a content description set to the string from
        // the R.string.back_button resource so we create a variable with its value
        val backText = composeTestRule.activity.getString(R.string.back_button)

        // We assert that a node with that content description doesn't exist
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    /**
     * Now It's testing time
     * Change the rest of the code to fit your app
     */


    // When clicking the Access button we go to the menu screen
    // So we write a command to click a button an trigger the navigation
    // to verify the destination route is the Menu screen
    @Test
    fun smartHomeNavHost_clickAccessButton_navigatesToMenuScreen(){
        // Search for the access button with its string resource
        composeTestRule.onNodeWithStringId(R.string.access)
            .performClick()
        // Assert that the current route name is the Menu screen name
        navController.assertCurrentRouteName(SmartHomeScreen.Menu.name)
    }


    // We now verify there is also no back button on the Menu Screen
    @Test
    fun smartHomeNavHost_verifyBackNavigationNotShownOnMenuScreen() {
        // In the app, the Up button has a content description set to the string from
        // the R.string.back_button resource so we create a variable with its value
        val backText = composeTestRule.activity.getString(R.string.back_button)

        // We assert that a node with that content description doesn't exist
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }



    // More helper methods, since the navigation isn't linear test will be a bit different
    // These aren't test methods so no @Test annotation is used
    private fun navigateToMenuScreen() {
        composeTestRule.onNodeWithStringId(R.string.access)
            .performClick()
    }

    private fun navigateToLightsScreen() {
        navigateToMenuScreen()
        composeTestRule.onNodeWithStringId(R.string.light)
            .performClick()
    }

    private fun navigateToAmbianceScreen() {
        navigateToMenuScreen()
        composeTestRule.onNodeWithStringId(R.string.temperature_and_humidity)
            .performClick()
    }

    private fun navigateToActivityScreen() {
        navigateToMenuScreen()
        composeTestRule.onNodeWithStringId(R.string.activity_log)
            .performClick()
    }

    // Helper method for the Up Button to go back to a previous screen
    private fun performNavigateUp() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }



    // Navigating to the lights screen
    @Test
    fun smartHomeNavHost_clickLightsOnMenuScreen_navigatesToLightsScreen() {
        navigateToMenuScreen()
        composeTestRule.onNodeWithStringId(R.string.light).performClick()
        navController.assertCurrentRouteName(SmartHomeScreen.Lights.name)
    }

    // Navigating to the Menu screen by clicking the Up button from the Lights screen
    @Test
    fun smartHomeNavHost_clickBackOnLightsScreen_navigatesToMenuScreen() {
        navigateToLightsScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(SmartHomeScreen.Menu.name)
    }


    // Navigating to the Ambiance screen
    @Test
    fun smartHomeNavHost_clickAmbianceOnMenuScreen_navigatesToAmbianceScreen() {
        navigateToMenuScreen()
        composeTestRule.onNodeWithStringId(R.string.ambiance).performClick()
        navController.assertCurrentRouteName(SmartHomeScreen.Ambiance.name)
    }

    // Navigating to the Menu screen by clicking the Up button from the Lights screen
    @Test
    fun smartHomeNavHost_clickBackOnAmbianceScreen_navigatesToMenuScreen() {
        navigateToAmbianceScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(SmartHomeScreen.Menu.name)
    }


    // Navigating to the Log screen
    @Test
    fun smartHomeNavHost_clickActivityOnMenuScreen_navigatesToActivityScreen() {
        navigateToMenuScreen()
        composeTestRule.onNodeWithStringId(R.string.activity_log).performClick()
        navController.assertCurrentRouteName(SmartHomeScreen.Activity.name)
    }

    // Navigating to the Menu screen by clicking the Up button from the Log screen
    @Test
    fun smartHomeNavHost_clickBackOnActivityScreen_navigatesToMenuScreen() {
        navigateToActivityScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(SmartHomeScreen.Menu.name)
    }
}
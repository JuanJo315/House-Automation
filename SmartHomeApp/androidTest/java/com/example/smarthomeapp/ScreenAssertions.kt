package com.example.smarthomeapp

import androidx.navigation.NavController
import org.junit.Assert.assertEquals

/* We use a file and not a class to use it later as an extension function

Tests require the repetition of steps for different pieces of code
Helpers are used to avoid writing duplicate code like assertions

We can write a helper for an assertion when we use the name property of the
CupcakeScreen enum items to check that the current destination route of the navigation controller is correct
 */

// We ad an extension to the NavController and give it a string with the expected route
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    // Make sure the expected route is the same as the destination route in the nav Controller's
    // current back stack entry
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}
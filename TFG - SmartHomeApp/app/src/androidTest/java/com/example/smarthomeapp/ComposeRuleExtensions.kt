package com.example.smarthomeapp

import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule


fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.onNodeWithStringId(
    @StringRes id: Int
): SemanticsNodeInteraction = onNodeWithText(activity.getString(id))

/*
    A number of tests also require interacting with UI components. Those components are
    often found using a resource string. You can access a composable by its resource
    string with the Context.getString() method

    This extension function allows you to reduce the amount of code you write when
    finding a UI component by its string resource

    For example, this
    composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.my_string)

    Becomes this
    composeTestRule.onNodeWithStringId(R.string.my_string)
 */
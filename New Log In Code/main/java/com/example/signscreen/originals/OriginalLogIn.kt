package com.example.signscreen.originals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.signscreen.ui.theme.SignScreenTheme

/**@Composable
fun OriginalLogInScreen(
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    var userInput by remember { mutableStateOf("") }
    var userInput2 by remember { mutableStateOf("") }

    var isWrong by remember { mutableStateOf(false) }
    var isWrong2 by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically)
    ) {

        Text("Log In Menu")

        // Account
        OutlinedTextField(
            value = userInput,
            singleLine = true,
            onValueChange = { userInput = it},
            label = {
                if (isWrong) {
                    Text("No Nickname Found, Try Again")
                } else {
                    Text("Enter Nickname")
                }
            },
            isError = isWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if(userInput == "Candy"){
                        focusManager.moveFocus(FocusDirection.Down)
                    } else {
                        isWrong = true
                    }
                }
            )
        )

        // Password
        OutlinedTextField(
            value = userInput2,
            singleLine = true,
            onValueChange = { userInput2 = it},
            label = {
                if (isWrong2) {
                    Text("Wrong Password")
                } else {
                    Text("Enter Password")
                }
            },
            isError = isWrong2,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if(userInput2 == "Lego"){
                        focusManager.moveFocus(FocusDirection.Down)
                    } else {
                        isWrong2 = true
                    }
                }
            )
        )

        // Check Credentials button for Access to App
        Button(onClick = { /*TODO*/
            if(!isWrong && !isWrong2) {
                onLogInButtonClicked()
            }
        }) {
            Text(text = "Access")
        }

        Row(
            modifier = Modifier. padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            Text(text = "You don't have an account?")

            Button(onClick = { /*TODO*/
                onSignUpButtonClicked()
            }) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OriginalLogInScreenPreview() {
    SignScreenTheme {
        OriginalLogInScreen()
    }
}*/
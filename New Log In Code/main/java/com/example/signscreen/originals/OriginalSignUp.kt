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
import com.google.firebase.database.FirebaseDatabase


/**@Composable
fun OriginalSignUpScreen(
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    var userInput by remember { mutableStateOf("") }
    var userInput2 by remember { mutableStateOf("") }
    var userInput3 by remember { mutableStateOf("") }
    var userInput4 by remember { mutableStateOf("") }

    var wrongPassword by remember { mutableStateOf(false) }
    var canAccess by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users")
    //val ref = userDatabase.child("Leo").child("name")
    //val ref = userDatabase.child("Leo")

    Column(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically)
    ) {

        Text("Sign Up Menu")

        // Username
        OutlinedTextField(
            value = userInput,
            singleLine = true,
            onValueChange = { userInput = it},
            label = {Text("Enter username")},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    //userDatabase.child("Leo").child("name").setValue(userInput)
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Account
        OutlinedTextField(
            value = userInput2,
            singleLine = true,
            onValueChange = { userInput2 = it},
            label = {Text("Enter Account")},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    //userDatabase.child("Leo").child("account").setValue(userInput2)
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Password
        OutlinedTextField(
            value = userInput3,
            singleLine = true,
            onValueChange = { userInput3 = it},
            label = {Text("Password")},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    //userDatabase.child("Leo").child("password").setValue(userInput3)
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Password Confirmation
        OutlinedTextField(
            value = userInput4,
            singleLine = true,
            onValueChange = { userInput4 = it},
            label = {Text("Confirm Password")},
            isError = wrongPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if(userInput3 != userInput4) {
                        wrongPassword = true
                        canAccess = false
                    } else {
                        wrongPassword = false
                        canAccess = true
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            )
        )

        // Check Credentials button for Access to App
        Button(onClick = {
            if(canAccess) {
                userDatabase.child("Leo").child("name").setValue(userInput)
                userDatabase.child("Leo").child("account").setValue(userInput2)
                userDatabase.child("Leo").child("password").setValue(userInput3)
                onSignUpButtonClicked()
            }
        }) {
            Text(text = "Access")
        }

        Row(
            modifier = Modifier. padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            Text(text = "You already have an account?")

            Button(onClick = { /*TODO*/ onLogInButtonClicked()}) {
                Text(text = "Log In")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OriginalSignUpScreenPreview() {
    SignScreenTheme {
        OriginalSignUpScreen()
    }
}*/
package com.example.smarthomeapp.ui.screens

import android.content.ContentValues
import android.util.Log
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
import com.example.smarthomeapp.ui.data.InputSignUp
import com.example.smarthomeapp.ui.data.User
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


@Composable
fun SignUpScreen(
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    var userInput by remember { mutableStateOf("") }
    var userInput2 by remember { mutableStateOf("") }
    var userInput3 by remember { mutableStateOf("") }
    var userInput4 by remember { mutableStateOf("") }

    var wrongUsername by remember { mutableStateOf(false) }
    var wrongPassword by remember { mutableStateOf(false) }
    var canAccess by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users")

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
            label = {
                if (wrongUsername) {
                    Text("Username Already Taken")
                } else {
                    Text("Enter Username")
                }
            },
            isError = wrongUsername,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    InputSignUp.username = userInput
                    userDatabase.child(InputSignUp.username).child("name").addValueEventListener(object :
                        ValueEventListener {
                        @Override
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            val value = dataSnapshot.getValue(String::class.java)
                            Log.d(ContentValues.TAG, "Value is: $value")
                            User.username = "$value"
                            if(InputSignUp.username == User.username) {
                                wrongUsername = true
                            }
                            if(InputSignUp.username != User.username) {
                                wrongUsername = false
                            }
                        }

                        @Override
                        override fun onCancelled(error: DatabaseError) {
                            // Failed to read value
                            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                            wrongUsername = false
                        }
                    })

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
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Password
        OutlinedTextField(
            value = userInput3,
            singleLine = true,
            onValueChange = { userInput3 = it},
            label = {
                if (wrongPassword) {
                    Text("Password Doesn't Match")
                } else {
                    Text("Enter Password")
                }
            },
            isError = wrongPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Password Confirmation
        OutlinedTextField(
            value = userInput4,
            singleLine = true,
            onValueChange = { userInput4 = it},
            label = {
                if (wrongPassword) {
                    Text("Password Doesn't Match")
                } else {
                    Text("Confirm Password")
                }
            },
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
                    }
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Check Credentials button for Access to App
        Button(onClick = {
            if(canAccess && !wrongUsername) {
                userDatabase.child(InputSignUp.username).child("name").setValue(userInput)
                userDatabase.child(InputSignUp.username).child("account").setValue(userInput2)
                userDatabase.child(InputSignUp.username).child("password").setValue(userInput3)
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
fun SignUpScreenPreview() {
    SmartHomeAppTheme {
        SignUpScreen()
    }
}
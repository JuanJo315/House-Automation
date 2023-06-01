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
import com.example.smarthomeapp.ui.data.InputLogIn
import com.example.smarthomeapp.ui.data.User
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun LogInScreen(
    onLogInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users")

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    //var usernameInput by remember { mutableStateOf(InputLogIn.username) }
    //var passwordInput by remember { mutableStateOf(InputLogIn.password) }

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

        // Username
        OutlinedTextField(
            value = usernameInput,
            singleLine = true,
            onValueChange = { usernameInput = it},
            label = {
                if (isWrong) {
                    Text("No Username Found, Try Again")
                } else {
                    Text("Enter Username")
                }
            },
            isError = isWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    InputLogIn.username = usernameInput

                    userDatabase.child(InputLogIn.username).child("name").addValueEventListener(object : ValueEventListener {
                        @Override
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            val value = dataSnapshot.getValue(String::class.java)
                            Log.d(ContentValues.TAG, "Value is: $value")
                            User.username = "$value"
                            /*if(Input.username != User.username) {
                                isWrong = true
                            }else{
                                isWrong = false
                            }*/
                            if(InputLogIn.username != User.username) {
                                isWrong = true
                            }
                            if(InputLogIn.username == User.username) {
                                isWrong = false
                            }
                        }

                        @Override
                        override fun onCancelled(error: DatabaseError) {
                            // Failed to read value
                            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                            isWrong = true
                        }
                    })

                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Password
        OutlinedTextField(
            value = passwordInput,
            singleLine = true,
            onValueChange = { passwordInput = it},
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
                    InputLogIn.password = passwordInput

                    userDatabase.child(InputLogIn.username).child("password").addValueEventListener(object : ValueEventListener {
                        @Override
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            val value = dataSnapshot.getValue(String::class.java)
                            Log.d(ContentValues.TAG, "Value is: $value")
                            User.password = "$value"
                            /*if(Input.password != User.password) {
                                isWrong2 = true
                            } else {
                                isWrong2 = false
                            }*/
                            if(InputLogIn.password != User.password) {
                                isWrong2 = true
                            }
                            if(InputLogIn.password == User.password) {
                                isWrong2 = false
                            }
                        }

                        @Override
                        override fun onCancelled(error: DatabaseError) {
                            // Failed to read value
                            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                        }
                    })

                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        // Check Credentials button for Access to App
        Button(onClick = { /*TODO*/
            if(!isWrong && !isWrong2 && usernameInput != "" && passwordInput != "") {
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
fun LogInScreenPreview() {
    SmartHomeAppTheme {
        LogInScreen()
    }
}
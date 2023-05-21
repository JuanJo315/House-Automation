package com.example.smarthomeapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.smarthomeapp.R

@Composable
fun PasswordScreen(
    onPasswordButtonClicked: () -> Unit = {},
) {
    var isWrong by remember {
        mutableStateOf(false)
    }

    var userInput by remember {
        mutableStateOf("")
    }

    var isWrong2 by remember {
        mutableStateOf(false)
    }

    var userInput2 by remember {
        mutableStateOf("")
    }

    /*var userInput3 by remember {
        mutableStateOf("")
    }*/

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically)
    ) {

        //OutlinedTextField(value = userInput, onValueChange = { userInput = it })
        //OutlinedTextField(value = userInput2, onValueChange = {userInput2 = it})
        //TextBox(input = userInput3, textWrong = "Wrong Password", textRight = "Enter Password", password = "Candy")

        // Account
        OutlinedTextField(
            value = userInput,
            singleLine = true,
            //modifier = Modifier.fillMaxWidth(),
            onValueChange = { userInput = it},
            label = {
                if (isWrong) {
                    Text("Wrong Account")
                } else {
                    Text("Enter Account")
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
            //modifier = Modifier.fillMaxWidth(),
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
                onPasswordButtonClicked()
            }
        }) {
            Text(text = stringResource(id = R.string.access))
        }
    }
}

/*@Composable
fun TextBox(
    input: String,
    textWrong: String,
    textRight: String,
    password: String
) {
    var inputChange by remember { mutableStateOf("") }
    var wrong: Boolean = false

    OutlinedTextField(
        //value = "",
        value = input,
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        // onValueChange = { },
        onValueChange = { inputChange = it},
        //label = { Text(stringResource(R.string.enter_your_word)) },
        label = {
            if (wrong) {
                Text(text = textWrong)
            } else {
                Text(textRight)
            }
        },
        //isError = false,
        isError = wrong,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                if(input == password){

                } else {
                    wrong = true
                }
            }
        )
    )
}
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasswordScreenPreview() {
    SmartHomeAppTheme {
        PasswordScreen()
    }
}



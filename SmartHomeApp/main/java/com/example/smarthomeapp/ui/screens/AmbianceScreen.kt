package com.example.smarthomeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smarthomeapp.ui.data.User
import com.google.firebase.database.FirebaseDatabase

@Composable
fun AmbianceScreen() {
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users").child(User.username)
    //var temp by remember { mutableStateOf(0.0) }
    //var hum by remember { mutableStateOf(0) }

    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "Temperature", modifier = Modifier.padding(16.dp))
            Text(text = "Humidity", modifier = Modifier.padding(16.dp))
        }
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "$temp º", modifier = Modifier.padding(16.dp))
            Text(text = "$hum %", modifier = Modifier.padding(16.dp))
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Recalculate")
        }
    }*/

    Column(
        modifier = Modifier.padding(top = 20.dp, bottom = 12.dp).fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {

            //ColumnCreated(textOne = "Temperature", textTwo = "$temp º")
            ColumnCreated(textOne = "Temperature", textTwo = "${User.temperature} º")

            Spacer(modifier = Modifier.width(40.dp))
            
            //ColumnCreated(textOne = "Humidity", textTwo = "$hum %")
            ColumnCreated(textOne = "Humidity", textTwo = "${User.humidity} %")

            /*Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Temperature", modifier = Modifier.padding(16.dp))
                Text(text = "$temp º", modifier = Modifier.padding(16.dp))
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Humidity", modifier = Modifier.padding(16.dp))
                Text(text = "$hum %", modifier = Modifier.padding(16.dp))
            }*/
        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = { /*TODO*/
            userDatabase.child("temperature").setValue(0.0)
            userDatabase.child("humidity").setValue(0)
        }) {
            Text(text = "Recalculate")
        }
    }
    /*Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        
        Column() {
            Text(text = "Temperature", modifier = Modifier.padding(16.dp))
            Text(text = "$temp º", modifier = Modifier.padding(16.dp))
        }

        Column() {
            Text(text = "Humidity", modifier = Modifier.padding(16.dp))
            Text(text = "$hum %", modifier = Modifier.padding(16.dp))
        }
    }*/
}

@Composable
fun ColumnCreated(
    textOne: String,
    textTwo: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = textOne)
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = textTwo)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AmbiancePreview() {
    SmartHomeAppTheme {
        AmbianceScreen()
    }
}
package com.example.smarthomeapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarthomeapp.R
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme
import com.example.smarthomeapp.ui.data.User
import com.google.firebase.database.FirebaseDatabase

@Composable
fun LightScreen(
    //lightState: Boolean = false
) {
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users").child(User.username)

    //var lights = lightState
    //var lights by remember { mutableStateOf(lightState) }

    var lights by remember { mutableStateOf(User.lights) }

    /*when(lights) {
        true -> Column(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "The lights are")
            ImageMethod(state = R.drawable.on)
            Text(text = "ON")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Click here to Turn OFF the Lights")
            Button(onClick = { /*TODO*/ lights = false}) {}
        }

        else -> Column(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "The lights are")
            ImageMethod(state = R.drawable.off)
            Text(text = "OFF")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Click here to Turn OFF the Lights")
            Button(onClick = { /*TODO*/ lights = true}) {}
        }
    }*/

    Column(
        //modifier = Modifier
            //.padding(top = 20.dp, bottom = 12.dp),
        modifier = Modifier.padding(top = 20.dp, bottom = 12.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "The lights are")

        if(lights == true) {
        //if(User.lights == true) {
            ImageMethod(state = R.drawable.on)
            Text(text = "ON")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Click here to Turn OFF the Lights")
            //Button(onClick = { /*TODO*/ lights = false}) {}
            Button(onClick = { /*TODO*/
                userDatabase.child("lights").setValue(false)
                //User.lights = false
                lights = false
            }) {}
        }
        else {
        //if(User.lights == false) {
            ImageMethod(state = R.drawable.off)
            Text(text = "OFF")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Click here to Turn ON the Lights")
            //Button(onClick = { /*TODO*/ lights = true}) {}
            Button(onClick = { /*TODO*/
                userDatabase.child("lights").setValue(true)
                //User.lights = true
                lights = true
            }) {}
        }
    }
}

@Composable
fun ImageMethod(@DrawableRes state: Int) {
    Image(painter = painterResource(id = state),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            //.size(150.dp)
            .size(180.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightScreenPreview() {
    SmartHomeAppTheme {
        LightScreen()
    }
}
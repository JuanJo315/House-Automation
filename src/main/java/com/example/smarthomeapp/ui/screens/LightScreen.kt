package com.example.smarthomeapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarthomeapp.R
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme

@Composable
fun LightScreen(
    lightState: Boolean = false
) {
    var lights = lightState

    Column(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "The lights are")

        if(lights) {
            ImageMethod(state = R.drawable.on)
            Text(text = "ON")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Click here to Turn OFF the Lights")
            Button(onClick = { /*TODO*/ lights = false}) {}
        }
        else {
            ImageMethod(state = R.drawable.off)
            Text(text = "OFF")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Click here to Turn ON the Lights")
            Button(onClick = { /*TODO*/ lights = true}) {}
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
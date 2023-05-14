package com.example.smarthomeapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarthomeapp.R
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme

@Composable
fun MenuScreen(
    onLightsButtonClicked: () -> Unit = {}
) {
    Column (
        modifier = Modifier
            .padding(top = 20.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(text = stringResource(id = R.string.app_name), Modifier.padding(16.dp))

        Image(painter = painterResource(id = R.drawable.blue_re_pict_house_base_png_128),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = { /*TODO*/ onLightsButtonClicked()}) {
                Text(stringResource(id = R.string.light))
            }

            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(id = R.string.temperature_and_humidity))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    SmartHomeAppTheme {
        MenuScreen()
    }
}
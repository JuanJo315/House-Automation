package com.example.smarthomeapp.ui.screens

import android.content.ContentValues
import android.util.Log
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
import com.example.smarthomeapp.ui.data.User
import com.example.smarthomeapp.ui.theme.SmartHomeAppTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun MenuScreen(
    onLightsButtonClicked: () -> Unit = {},
    onAmbianceButtonClicked: () -> Unit = {},
    onActivityButtonClicked: () -> Unit = {}
) {
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users").child(User.username)

    Column (
        modifier = Modifier//.padding(16.dp).fillMaxWidth(),
            //.padding(top = 20.dp, bottom = 12.dp),
            .padding(top = 20.dp, bottom = 12.dp).fillMaxWidth(),
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
            Button(onClick = { /*TODO*/
                userDatabase.child("lights").addValueEventListener(object :
                    ValueEventListener {
                    @Override
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        val value = dataSnapshot.getValue(Boolean::class.java)
                        Log.d(ContentValues.TAG, "Value is: $value")
                        //User.lights = value
                        if (value == false){
                            User.lights = value
                        }
                        if (value == true){
                            User.lights = value
                        }
                        if (value == null){
                            userDatabase.child("lights").setValue(false)
                            User.lights = false
                        }
                    }

                    @Override
                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                        userDatabase.child("lights").setValue(false)
                    }
                })
                onLightsButtonClicked()}) {
                Text(stringResource(id = R.string.light))
            }

            Button(onClick = { /*TODO*/
                userDatabase.child("temperature").addValueEventListener(object :
                    ValueEventListener {
                    @Override
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        val value = dataSnapshot.getValue(Double::class.java)
                        Log.d(ContentValues.TAG, "Value is: $value")
                        //User.temperature = value
                        if(User.temperature != null){
                            User.temperature = value
                        }
                        if (value == null){
                            userDatabase.child("temperature").setValue(0.0)
                            User.temperature = 0.0
                        }
                    }

                    @Override
                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                        userDatabase.child("temperature").setValue(0.0)
                    }
                })

                userDatabase.child("humidity").addValueEventListener(object :
                    ValueEventListener {
                    @Override
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        val value = dataSnapshot.getValue(Int::class.java)
                        Log.d(ContentValues.TAG, "Value is: $value")
                        //User.humidity = value
                        if(User.humidity != null){
                            User.humidity = value
                        }
                        if (value == null){
                            userDatabase.child("humidity").setValue(0)
                            User.humidity = 0
                        }
                    }

                    @Override
                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                        userDatabase.child("humidity").setValue(0)
                    }
                })
                onAmbianceButtonClicked()}) {
                Text(stringResource(id = R.string.temperature_and_humidity))
            }

            Button(onClick = { /*TODO*/ onActivityButtonClicked()}) {
                Text(stringResource(id = R.string.activity_log))
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
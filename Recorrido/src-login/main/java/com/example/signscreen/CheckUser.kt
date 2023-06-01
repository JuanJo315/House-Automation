package com.example.signscreen

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * File created to show 2 Screens
 * First Screen is correct Login with good read
 * Second Screen is failed Login as user input isn't in database
 */
/*
@Composable
fun CheckUser(
    onUserDataButtonClicked: () -> Unit = {}
) {
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users").child("Leo").child("account")

    userDatabase.addValueEventListener(object : ValueEventListener {
        @Override
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            val value = dataSnapshot.getValue(String::class.java)
            Log.d(ContentValues.TAG, "Value is: $value")
            //userdata = "$value"
            //User("$value")
            // User.name = "$value"
            User(name ="$value")
        }

        @Override
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    })

    Column {
        // Text(text ="User name is" + User.name)
        Text(text ="User name is" + User().name)

        Button(onClick = { /*TODO*/ onUserDataButtonClicked()}) {
            Text(text = "User Data")
        }
    }

 */
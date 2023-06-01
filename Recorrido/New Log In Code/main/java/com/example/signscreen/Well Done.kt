package com.example.signscreen

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
//import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


/**
 * File used to read data from the data base and show the read data in User Data file
 */

@Composable
fun WellDone() {
    Column {
        Text(text ="User name is " + User.username)
    }
}
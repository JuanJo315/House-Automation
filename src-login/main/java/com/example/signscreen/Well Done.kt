package com.example.signscreen

//import androidx.lifecycle.viewModelScope

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


//import kotlinx.coroutines.launch
//import java.io.IOException


/**
 * File used to read data from the data base and show the read data in User Data file
 */

@Composable
fun WellDone(
    onUserDataButtonClicked: () -> Unit = {},
    //onUserDataButtonClicked: (String) -> Unit = {}
    //viewModel: ViewModel = viewModel()
) {
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users").child("Leo").child("name")

    //var name = ""

    //var show = false

    //var userdata = ""

    userDatabase.addValueEventListener(object : ValueEventListener {
        @Override
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            val value = dataSnapshot.getValue(String::class.java)
            Log.d(TAG, "Value is: $value")
            //userdata = "$value"
            //User("$value")
            User.name = "$value"
            //User(name = "$value")
            //name = "$value"
            //viewModel.changeAccount("$value")
        }

        @Override
        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(TAG, "Failed to read value.", error.toException())
        }
    })

    Column {
        Text(text ="User name is" + User.name)
        //Text(text ="User name is" + User().name)

        Button(onClick = { /*TODO*/ onUserDataButtonClicked()}) {
            Text(text = "User Data")
        }

        /*// To check if both methods work
        Button(onClick = { /*TODO*/ onUserDataButtonClicked(name)}) {
            Text(text = "User Data")
        }
         */

    }
}

/**
 * @Composable
fun WellDone(
onUserDataButtonClicked: () -> Unit = {},
//onUserDataButtonClicked: (String) -> Unit = {}
//viewModel: ViewModel = viewModel()
) {
val database = FirebaseDatabase.getInstance()
val userDatabase = database.getReference("Users").child("Leo").child("account")

//var account = ""

//var show = false

//var userdata = ""

userDatabase.addValueEventListener(object : ValueEventListener {
@Override
override fun onDataChange(dataSnapshot: DataSnapshot) {
// This method is called once with the initial value and again
// whenever data at this location is updated.
val value = dataSnapshot.getValue(String::class.java)
Log.d(TAG, "Value is: $value")
//userdata = "$value"
//User("$value")
// User.name = "$value"
User(name ="$value")
//account = "$value"
//viewModel.changeAccount("$value")
}

@Override
override fun onCancelled(error: DatabaseError) {
// Failed to read value
Log.w(TAG, "Failed to read value.", error.toException())
}
})

Column {
// Text(text ="User name is" + User.name)
Text(text ="User name is" + User().name)

Button(onClick = { /*TODO*/ onUserDataButtonClicked()}) {
Text(text = "User Data")
}

/*// To check if both methods work
Button(onClick = { /*TODO*/ onUserDataButtonClicked(account)}) {
Text(text = "User Data")
}
*/
}
}
 */

    /*Column {
        Text(text = "Congrats")

        //Text("name:" + userDatabase.child("Leo").child("account").get())

        /*userDatabase.child("Leo").child("account").get().addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.e("firebase", "Error getting data", task.exception)
            } else {
                Log.d("firebase", java.lang.String.valueOf(task.result.value))
            }
        }*/

        userDatabase.get().addOnSuccessListener {
            Log.e("firebase", "Success getting data + ${it.value}")
            println("${it.value}")
            show = true
        }

        when(show){
            true -> Text(userDatabase.get().result.toString())
            false -> Text(text = "No Value")
        }

        //Text(text = getText())


        /*userDatabase.child("Leo").child("account").get().addOnCanceledListener {
            Log.e("firebase", "Cancel getting data")
        }

        userDatabase.child("Leo").child("account").get().addOnFailureListener {
            Log.e("firebase", "Failure getting data")
        }*/
    }
}*/

/**@Composable
fun GetText() {
    var information = ""
    val database = FirebaseDatabase.getInstance()
    val userDatabase = database.getReference("Users").child("Leo").child("account")


    /*userDatabase.get().addOnSuccessListener {
        Log.e("firebase", "Success getting data + ${it.value}")
        information = "${it.value}"
    }

    return information

     */
}
*/

        /**userDatabase.child("Leo").child("account").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d(TAG, "Value is: $value")
                //Text("name:" + userDatabase.child("Leo").child("account").key)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        userDatabase.child("Leo").child("account").get()
            .addOnCompleteListener(OnCompleteListener<DataSnapshot?> { task ->
                if (!task.isSuccessful) {
                    Log.e("firebase", "Error getting data", task.exception)
                } else {
                    Log.d("firebase", java.lang.String.valueOf(task.result.value))
                }
            })*/

/**val postListener = object : ValueEventListener {
override fun onDataChange(dataSnapshot: DataSnapshot) {
// Get Post object and use the values to update the UI
val post = dataSnapshot.getValue()
// ...
}

override fun onCancelled(databaseError: DatabaseError) {
// Getting Post failed, log a message
Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
}
}
postReference.addValueEventListener(postListener)*/

/**userDatabase.child("Leo").child("account").get().addOnSuccessListener {
Log.i("firebase", "Got value ${it.value}")
}.addOnFailureListener{
Log.e("firebase", "Error getting data", it)
}*/

/**ValueEventListener listener;
ArrayList<Requests> requestList = new ArrayList<>();
listener = new ValueEventListener() {

@Override
public void DataChange(DataSnapshot dataSnapshot) {
try{
for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
Requests obj = postSnapshot.getValue(Requests.class);
requestList.add(obj)
}
//You will get the list of request objects here and you can parse products from it via loop
//Handle your code here further
} catch(Exception e){
e.printStackTrace();
}
}
@Override
public void onCancelled(DatabaseError databaseError) {

}
};

database.addValueEventListener(listener);on*/
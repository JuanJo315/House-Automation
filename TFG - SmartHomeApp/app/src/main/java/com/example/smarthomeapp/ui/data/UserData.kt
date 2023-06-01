package com.example.smarthomeapp.ui.data

// Database User Data
object User {
    var username: String = ""
    var name: String = ""
    var password: String = ""
    var lights: Boolean? = false
    var temperature: Double? = 0.0
    var humidity: Int? = 0
}

// User new data when signing up or logging in
object InputLogIn {
    var username: String = ""
    var password: String = ""
}

object InputSignUp {
    var username: String = ""
    var name: String = ""
}
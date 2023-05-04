package com.example.minor_tbd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserInfo")
data class UserInfo(

    @PrimaryKey (autoGenerate = true)
    var uid: Int,
    var Name: String,
    var Surname : String,
    var email: String,
    var password: String,
    var phoneNumber: String,
)

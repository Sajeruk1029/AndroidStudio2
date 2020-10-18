package com.example.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Array

class Data {
    @SerializedName("value")
    @Expose
    var objectWithJoke : Joke? = null
}

class Joke {
    @SerializedName("joke")
    @Expose
    var joke : String? = null
}

class DataPost{
    @SerializedName("userName")
    @Expose
    private var userName : String = ""

    @SerializedName("password")
    @Expose
    private var password : String = ""

    @SerializedName("email")
    @Expose
    private var email : String = ""

    @SerializedName("userId")
    @Expose
    private var userId : Int = 0

    fun getName() : String {
        return this.userName
    }

    fun getPasswd() : String {
        return this.password
    }

    fun getEmail() : String {
        return this.email
    }

    fun getUserId() : Int {
        return this.userId
    }

    fun setName(name : String) {
        this.userName = name
    }

    fun setPasswd(pass : String) {
        this.password = pass
    }

    fun setEmail(email : String) {
        this.email = email
    }

    fun setUserId(id : Int) {
        this.userId = id
    }
}
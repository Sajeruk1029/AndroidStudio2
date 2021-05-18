package com.example.mvvm.models

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import androidx.databinding.BaseObservable
import com.example.mvvm.db.DBHelper

class User(private var email : String, private var password : String) : BaseObservable(){

    //fun isDataValid() : Boolean{ return ((!TextUtils.isEmpty(email)) && (Patterns.EMAIL_ADDRESS.matcher(email).matches()) && (password.length > 6)) }
    fun isDataValid(view : View) : Boolean
    {
        val db : DBHelper = DBHelper(view.context)
        val model : UserModel = db.showCurrentData(UserModel(0, email, password))

        return ((model.getLogin() != "") && (model.getPassword() != ""))
    }

    fun getPassword() : String { return password }
    fun getEmail() : String { return email }

    fun setPassword(pass : String) { password = pass }
    fun setEmail(mail : String){ email = mail }



}
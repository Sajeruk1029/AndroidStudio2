package com.example.mvvm.models

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvm.intefaces.LoginResultCallBacks
import com.example.mvvm.db.DBHelper
import com.example.mvvm.models.UserModel


class LoginViewModel(private val listener : LoginResultCallBacks) : ViewModel() {

    private val user : User

    init {
        user = User("", "")
    }

    fun emailTextWatcher() : TextWatcher {

            return object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

                override fun afterTextChanged(s: Editable?) { user.setEmail(s.toString()) }
        }
    }

    fun passwordTextWatcher() : TextWatcher {

        return object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) { user.setPassword(s.toString()) }
        }
    }

    fun onLoginClicked(view : View){
        if(user.isDataValid(view)){
            listener.onSuccess("Success")
        }
        else {
            listener.onError("Failed")
        }
    }

    fun onRegistrationClicked(view : View){
        val db : DBHelper = DBHelper(view.context)

        db.addData(UserModel(0, user.getEmail(), user.getPassword()))
    }

}
package com.example.mvvm.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.intefaces.LoginResultCallBacks

class LoginViewModelFactory(private val listner : LoginResultCallBacks) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T { return LoginViewModel(listner) as T }
}
package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.intefaces.LoginResultCallBacks
import com.example.mvvm.models.LoginViewModel
import com.example.mvvm.models.LoginViewModelFactory

class MainActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding : ActivityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
    }

    override fun onSuccess(msg: String) { Toast.makeText(this, msg, Toast.LENGTH_SHORT).show() }

    override fun onError(msg: String) { Toast.makeText(this, msg, Toast.LENGTH_SHORT).show() }
}
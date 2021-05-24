package com.example.navigationdrawer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        Executors.newSingleThreadScheduledExecutor().schedule({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5, TimeUnit.SECONDS)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
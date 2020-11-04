package com.example.unittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, FirstTest("http://newsapi.org/v2/top-headlines?country=us&apiKey=1b93bc09293f461aa6ce921812fc7294").get_result(), Toast.LENGTH_LONG).show()
    }
}
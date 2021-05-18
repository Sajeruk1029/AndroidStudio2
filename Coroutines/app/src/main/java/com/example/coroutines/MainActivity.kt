package com.example.coroutines

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Будет работать пока жизненый цикл не умрет
       /* GlobalScope.launch {
            initArray()
        }*/
        // Поток будет уничтожен после выполнения программы
        CoroutineScope(Dispatchers.IO).launch {
            initArray()
        }

        btn.setOnClickListener{
            Toast.makeText(this, "Клик", Toast.LENGTH_SHORT).show()
        }

    }

    fun initArray() {
        var array = List(5000000){Random.nextInt(0, 100)}
        val adapter: ArrayAdapter<Int> = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_list_item_1, array
        )
        runOnUiThread{
        linear.adapter = adapter
        }

    }
}
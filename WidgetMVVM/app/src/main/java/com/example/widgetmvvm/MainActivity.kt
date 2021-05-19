package com.example.widgetmvvm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.widgetmvvm.adapter.ListViewAdapter
import com.example.widgetmvvm.adapter.UserDto
import com.example.widgetmvvm.model.Data
import com.example.widgetmvvm.model.DataBaseHelper
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {
    var adapter: ListViewAdapter? = null
    var DB = DataBaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cancel_button.visibility = View.GONE

        var listView: ListView? = null
        listView = findViewById<ListView>(R.id.listview)

        adapter = ListViewAdapter(this,DB.select())

        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    override fun onRestart() {
        adapter?.notifyDataSetChanged()
        super.onRestart()
    }

    fun addtask(v: View) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        var intent = Intent(this, AddTask::class.java)
        startActivity(intent)
    }


}
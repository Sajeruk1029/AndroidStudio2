package com.example.widgetmvvm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.widgetmvvm.databinding.ActivityAddTaskBinding
import com.example.widgetmvvm.viewmodel.DataViewModel
import com.example.widgetmvvm.viewmodel.DataViewModelFactory
import kotlinx.android.synthetic.main.toolbar.*

class AddTask : AppCompatActivity(), LoginResultCallBacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val activityAddTaskBinding =
            DataBindingUtil.setContentView<ActivityAddTaskBinding>(this, R.layout.activity_add_task)
        activityAddTaskBinding.viewmodel =
            ViewModelProviders.of(this, DataViewModelFactory(this)).get(DataViewModel::class.java)

        add.visibility = View.GONE
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun Cansel(v:View)
    {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
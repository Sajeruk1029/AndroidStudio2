package com.example.widgetmvvm.viewmodel

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import com.example.widgetmvvm.LoginResultCallBacks
import com.example.widgetmvvm.MainActivity
import com.example.widgetmvvm.adapter.ListViewAdapter
import com.example.widgetmvvm.model.Data
import com.example.widgetmvvm.model.DataBaseHelper
import java.util.*

class DataViewModel(private val listener: LoginResultCallBacks) : ViewModel() {

    private val data: Data

    init {
        this.data = Data("", 0);
    }

    val TextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                data.setText(p0.toString())
            }
        }

    fun test(v: View) {
        var check = v as CheckBox
        if (v.isChecked) {
            listener.onSuccess("true")
            data.setCheck(1)
        } else {
            listener.onSuccess("false")
            data.setCheck(0)
        }
    }

    var DB: DataBaseHelper? = null
    var adapter: ListViewAdapter? = null
    fun onAddClicked(v: View) {
        if (data.isDataValid) {
            DB = DataBaseHelper(v.context)
            DB!!.addData(data.getText(), data.getCheck())
            v.getContext().startActivity(Intent(v.getContext(), MainActivity::class.java))
            listener.onSuccess("Данные были добавлены")
        } else {
            listener.onError("Ошибка")
        }

    }

}


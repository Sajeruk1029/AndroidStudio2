package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.RadioGroup
import android.widget.Toast
import com.example.sqlite.Models.ModelData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    lateinit var peopleDb : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ModeSelector.setOnCheckedChangeListener(this)

        RadioAdd.isChecked = true

        peopleDb = DBHelper(this)

    }

    fun addData() {
        if(peopleDb.addData(ModelData(EditName.text.toString(), EditEmail.text.toString()))){
            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteData() {
        if(peopleDb.deleteData(ModelData(EditName.text.toString(), EditEmail.text.toString()))){
            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateData() {
        if(peopleDb.updateData(ModelData(EditName.text.toString(), EditEmail.text.toString()), ModelData(EditNewName.text.toString(), EditNewEmail.text.toString()))){
            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show()
        }
    }

    fun showData(){

        val data : MutableList<ModelData> = peopleDb.showData()
        val arr : MutableList<String> = arrayListOf()

        List.adapter = null

        for(iterator : ModelData in data){
            arr.add("Id: ${iterator.getId()} Name: ${iterator.getName()} Email: ${iterator.getEmail()}")
        }

        List.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr)

        Toast.makeText(this, "Success! Number of rows in the database: ${data.count()}", Toast.LENGTH_SHORT).show()
    }

    fun onClickExecute(view : View){
        when(ModeSelector.checkedRadioButtonId){
            R.id.RadioAdd ->{
                addData()
            }

            R.id.RadioDelete ->{
                deleteData()
            }

            R.id.RadioUpdate ->{
                updateData()
            }

            R.id.RadioShow ->{
                showData()
            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when(p1) {
            R.id.RadioAdd ->{
                EditNewName.isEnabled = false
                EditNewEmail.isEnabled = false
                EditName.isEnabled = true
                EditEmail.isEnabled = true
            }

            R.id.RadioDelete ->{
                EditNewName.isEnabled = false
                EditNewEmail.isEnabled = false
                EditName.isEnabled = true
                EditEmail.isEnabled = true
            }

            R.id.RadioUpdate ->{
                EditNewName.isEnabled = true
                EditNewEmail.isEnabled = true
                EditName.isEnabled = true
                EditEmail.isEnabled = true
            }

            R.id.RadioShow ->{
                EditNewName.isEnabled = false
                EditNewEmail.isEnabled = false
                EditName.isEnabled = false
                EditEmail.isEnabled = false
            }
        }
    }


}
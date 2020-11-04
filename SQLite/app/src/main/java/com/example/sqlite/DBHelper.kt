package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlite.Models.ModelData
import java.util.ArrayList

class DBHelper(context : Context) : SQLiteOpenHelper(context, "people.db", null, 1){

    val tableName : String = "people_table"
    val colOne : String = "Id"
    val colTwo : String = "Name"
    val colThree : String = "Email"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $tableName ($colOne INTEGER PRIMARY KEY AUTOINCREMENT, $colTwo TEXT, $colThree TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(p0)
    }

    fun addData(data : ModelData) : Boolean {

        val contentValues: ContentValues = ContentValues()

        contentValues.put(colTwo, data.getName())
        contentValues.put(colThree, data.getEmail())

        return this.writableDatabase.insert(tableName, null, contentValues) != -1L
    }

    fun deleteData(data : ModelData) : Boolean {
        return this.writableDatabase.delete(tableName, "$colTwo = '${data.getName()}' AND $colThree = '${data.getEmail()}'", null) != -1
    }

    fun updateData(data : ModelData, newData : ModelData) : Boolean{

        val contentValues : ContentValues = ContentValues()

        contentValues.put(colTwo, newData.getName())
        contentValues.put(colThree, newData.getEmail())

        return this.writableDatabase.update(tableName, contentValues, "$colTwo = '${data.getName()}' AND $colThree = '${data.getEmail()}'", null) != -1
    }

    fun showData() : MutableList<ModelData>{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), null, null, null, null, null)
        val massData : MutableList<ModelData> = arrayListOf()

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    massData.add(ModelData(cursor.getInt(cursor.getColumnIndex(colOne)), cursor.getString(cursor.getColumnIndex(colTwo)), cursor.getString(cursor.getColumnIndex(colThree))))
                }while (cursor.moveToNext())
            }
        }

        return massData
    }
}
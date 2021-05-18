package com.example.mvvm.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mvvm.models.UserModel
import java.util.ArrayList

class DBHelper(context : Context) : SQLiteOpenHelper(context, "people.db", null, 1){

    val tableName : String = "people_table"
    val colOne : String = "Id"
    val colTwo : String = "Email"
    val colThree : String = "Password"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $tableName ($colOne INTEGER PRIMARY KEY AUTOINCREMENT, $colTwo TEXT, $colThree TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(p0)
    }

    fun addData(data : UserModel) : Boolean {

        val contentValues: ContentValues = ContentValues()

        contentValues.put(colTwo, data.getLogin())
        contentValues.put(colThree, data.getPassword())

        return this.writableDatabase.insert(tableName, null, contentValues) != -1L
    }

    fun deleteData(data : UserModel) : Boolean {
        return this.writableDatabase.delete(tableName, "$colTwo = '${data.getLogin()}' AND $colThree = '${data.getPassword()}'", null) != -1
    }

    fun updateData(data : UserModel, newData : UserModel) : Boolean{

        val contentValues : ContentValues = ContentValues()

        contentValues.put(colTwo, newData.getLogin())
        contentValues.put(colThree, newData.getPassword())

        return this.writableDatabase.update(tableName, contentValues, "$colTwo = '${data.getLogin()}' AND $colThree = '${data.getPassword()}'", null) != -1
    }

    fun showData() : MutableList<UserModel>{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), null, null, null, null, null)
        val massData : MutableList<UserModel> = arrayListOf()

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    massData.add(UserModel(cursor.getInt(cursor.getColumnIndex(colOne)), cursor.getString(cursor.getColumnIndex(colTwo)), cursor.getString(cursor.getColumnIndex(colThree))))
                }while (cursor.moveToNext())
            }
        }

        return massData
    }

    fun showCurrentData(findmodel : UserModel) : UserModel{
        var model : UserModel = UserModel(0, "", "")
        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), "$colTwo = '${findmodel.getLogin()}' AND $colThree = '${findmodel.getPassword()}'", null, null, null, null)

        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    model.setId(cursor.getInt(cursor.getColumnIndex(colOne)))
                    model.setLogin(cursor.getString(cursor.getColumnIndex(colTwo)))
                    model.setPassword(cursor.getString(cursor.getColumnIndex(colThree)))
                }while (cursor.moveToNext())
            }
        }
        return model
    }
}
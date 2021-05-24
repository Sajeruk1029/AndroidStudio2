package com.example.navigationdrawer

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.navigationdrawer.ModelData

class DBHelper(context : Context) : SQLiteOpenHelper(context, "bugs.db", null, 1){

    val tableName : String = "bugs_table"
    val colOne : String = "Id"
    val colTwo : String = "Number"
    val colThree : String = "Type"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $tableName ($colOne INTEGER PRIMARY KEY AUTOINCREMENT, $colTwo INTEGER NOT NULL, $colThree INTEGER NOT NULL)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(p0)
    }

    fun addData(data : ModelData) : Boolean {

        val contentValues: ContentValues = ContentValues()

        contentValues.put(colTwo, data.getNumber())
        contentValues.put(colThree, data.getType())

        return this.writableDatabase.insert(tableName, null, contentValues) != -1L
    }

    fun deleteData(data : ModelData) : Boolean {
        return this.writableDatabase.delete(tableName, "$colOne = ${data.getId()}", null) != -1
    }

    fun deleteAllData() : Boolean {
        return this.writableDatabase.delete(tableName, "", null) != -1
    }

    fun updateData(data : ModelData, newData : ModelData) : Boolean{

        val contentValues : ContentValues = ContentValues()

        contentValues.put(colTwo, newData.getNumber())
        contentValues.put(colThree, newData.getType())

        return this.writableDatabase.update(tableName, contentValues, "$colOne = ${data.getId()}", null) != -1
    }

    fun showData() : MutableList<ModelData>{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), null, null, null, null, null)
        val massData : MutableList<ModelData> = arrayListOf()

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    massData.add(ModelData(cursor.getInt(cursor.getColumnIndex(colOne)), cursor.getInt(cursor.getColumnIndex(colTwo)), cursor.getInt(cursor.getColumnIndex(colThree))))
                }while (cursor.moveToNext())
            }
        }
        return massData
    }

    fun showDataSalt() : MutableList<ModelData>{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), "$colThree = 0", null, null, null, null)
        val massData : MutableList<ModelData> = arrayListOf()

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    massData.add(ModelData(cursor.getInt(cursor.getColumnIndex(colOne)), cursor.getInt(cursor.getColumnIndex(colTwo)), cursor.getInt(cursor.getColumnIndex(colThree))))
                }while (cursor.moveToNext())
            }
        }
        return massData
    }

    fun showDataPepper() : MutableList<ModelData>{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), "$colThree = 1", null, null, null, null)
        val massData : MutableList<ModelData> = arrayListOf()

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    massData.add(ModelData(cursor.getInt(cursor.getColumnIndex(colOne)), cursor.getInt(cursor.getColumnIndex(colTwo)), cursor.getInt(cursor.getColumnIndex(colThree))))
                }while (cursor.moveToNext())
            }
        }
        return massData
    }

    fun showNumberData() : Int{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), null, null, null, null, null)

        var number : Int = 0

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    number += cursor.getInt(cursor.getColumnIndex(colTwo))
                }while (cursor.moveToNext())
            }
        }
        return number
    }

    fun showNumberDataSalt() : Int{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), "$colThree = 0", null, null, null, null)

        var number : Int = 0

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    number += cursor.getInt(cursor.getColumnIndex(colTwo))
                }while (cursor.moveToNext())
            }
        }
        return number
    }

    fun showNumberDataPepper() : Int{

        val cursor : Cursor = this.readableDatabase.query(tableName, arrayOf(colOne, colTwo, colThree), "$colThree = 1", null, null, null, null)

        var number : Int = 0

        if(cursor != null) {
            if(cursor.moveToFirst()){
                do{
                    number += cursor.getInt(cursor.getColumnIndex(colTwo))
                }while (cursor.moveToNext())
            }
        }
        return number
    }
}
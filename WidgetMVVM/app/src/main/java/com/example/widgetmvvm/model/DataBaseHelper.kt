package com.example.widgetmvvm.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context?) : SQLiteOpenHelper(context, "data.db", null, 1) {

    val TABLE_NAME = "data_table"
    val COL = "TEXT_TASK"
    val COL2 = "CHEKED"

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL TEXT,$COL2 INTEGER)"
        p0!!.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun addData(text: String, check: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL, text)
        contentValues.put(COL2, check)
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L;
    }

    fun select(): ArrayList<Data> {
        var arrayList: ArrayList<Data> = ArrayList()
        val db = this.writableDatabase
        var cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)


        if (cursor!!.getCount() == 0) {
            return ArrayList()
        }

        while (cursor.moveToNext()) {
            arrayList.add(Data(cursor.getString(1), cursor.getInt(2)))
        }

        return arrayList
    }

    fun selectTrue(): ArrayList<Data> {
        var arrayList: ArrayList<Data> = ArrayList()
        val db = this.writableDatabase
        var cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)


        if (cursor!!.getCount() == 0) {
            return ArrayList()
        }

        while (cursor.moveToNext()) {
            if (cursor.getInt(2) == 1)
                arrayList.add(Data(cursor.getString(1), cursor.getInt(2)))
        }

        return arrayList
    }

}
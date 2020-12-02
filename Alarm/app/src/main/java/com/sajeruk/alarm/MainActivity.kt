package com.sajeruk.alarm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButStart.setOnClickListener(){
            Alarm(TimeSetter.hour, TimeSetter.minute)
        }
    }

    fun Alarm(hours : Int, minutes : Int)
    {
        val alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val date : Date = Date()
        val calendarDate : Calendar = Calendar.getInstance()
        val now : Calendar = Calendar.getInstance()
        val requestCode : Int = Random().nextInt()
        val intent : Intent = Intent(this, Alarmer::class.java).putExtra("key", requestCode).addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES).addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
        val pendingIntent : PendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        calendarDate.time = date
        now.time = date
        calendarDate.add(Calendar.HOUR, hours - now.get(Calendar.HOUR))
        calendarDate.add(Calendar.MINUTE, minutes - now.get(Calendar.MINUTE))

        if(calendarDate.before(now)) {
            calendarDate.add(Calendar.DATE, 1)
        }

        alarmManager.set(AlarmManager.RTC, calendarDate.timeInMillis, pendingIntent)
        Toast.makeText(this, "Alarm start: ${now.get(Calendar.HOUR)}:${now.get(Calendar.MINUTE)}. Alarm end: ${calendarDate.get(Calendar.HOUR)}:${calendarDate.get(Calendar.MINUTE)}. Alarm will go off in: ${hours - now.get(Calendar.HOUR)}:${minutes - now.get(Calendar.MINUTE)}", Toast.LENGTH_SHORT).show()
    }
}
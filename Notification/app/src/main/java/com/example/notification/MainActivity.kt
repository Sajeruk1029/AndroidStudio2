package com.example.notification

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butadd.setOnClickListener(){

            val notificationCompatBuilder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, "channelAdder").setContentTitle("Result").setContentText(((numberone.text.toString().toInt() + numbertwo.text.toString().toInt()).toString())).setPriority(NotificationCompat.PRIORITY_DEFAULT).setSmallIcon(R.drawable.ic_launcher_background)

            with(NotificationManagerCompat.from(applicationContext)){
                notify(111, notificationCompatBuilder.build())
            }

        }

    }
}
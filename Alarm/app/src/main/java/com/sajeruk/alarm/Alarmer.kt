package com.sajeruk.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.widget.Toast

class Alarmer : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "ALARM!", Toast.LENGTH_SHORT).show()

        val uriSound : Uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_ALARM)
        val ringtone : Ringtone = RingtoneManager.getRingtone(context, uriSound)

        ringtone.play()
    }
}
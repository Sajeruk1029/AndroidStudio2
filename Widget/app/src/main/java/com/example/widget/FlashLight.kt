package com.example.widget

import android.Manifest
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Camera
import android.hardware.camera2.CameraManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

/**
 * Implementation of App Widget functionality.
 */

const val widget : String = "But"
var poweroff : Boolean = false

class FlashLight : AppWidgetProvider() {



    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }

    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created

    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }


    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("DEBUG", "Click " + poweroff.toString())

        if(!poweroff){

            if(!context!!.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
                Toast.makeText(context, "You haven't a camera!", Toast.LENGTH_SHORT).show()

                Log.d("DEBUG", "2")

                return
            }

            Log.d("DEBUG", "3")

            if((ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)){
                Toast.makeText(context, "You haven't permissions!", Toast.LENGTH_SHORT).show()

                Log.d("DEBUG", "4")

                return
            }

            Log.d("DEBUG", "5")

            if((context!!.getSystemService(Context.CAMERA_SERVICE) as CameraManager) == null){
                Toast.makeText(context, "You haven't a camera!", Toast.LENGTH_SHORT).show()

                Log.d("DEBUG", "6")

                return
            }

            Log.d("DEBUG", "7")

            (context!!.getSystemService(Context.CAMERA_SERVICE) as CameraManager).setTorchMode((context!!.getSystemService(Context.CAMERA_SERVICE) as CameraManager).cameraIdList[0], true)

            poweroff = true
        }
        else{
            (context!!.getSystemService(Context.CAMERA_SERVICE) as CameraManager).setTorchMode((context!!.getSystemService(Context.CAMERA_SERVICE) as CameraManager).cameraIdList[0], false)

            poweroff = false
        }

        updateAppWidget(context!!, AppWidgetManager.getInstance(context), intent!!.getIntExtra("appWidgetId", 0))

        super.onReceive(context, intent)
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {

    val intent : Intent = Intent(context, FlashLight::class.java)

    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.flash_light)

    intent.action = widget
    intent.putExtra("appWidgetId", appWidgetId)

    views.setOnClickPendingIntent(R.id.But, PendingIntent.getBroadcast(context, 0, intent, 0))

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}


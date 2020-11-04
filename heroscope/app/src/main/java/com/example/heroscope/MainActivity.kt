package com.example.heroscope

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager : SensorManager
    lateinit var heroscope : Sensor

    var X : Float? = 0.0F
    var Y : Float? = 0.0F
    var Z : Float? = 0.0F

    lateinit var coords : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        heroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        coords = findViewById(R.id.Coords)

        coords.text = "[x,y,z]"

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, heroscope, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        X = p0?.values?.get(0)
        Y = p0?.values?.get(1)
        Z = p0?.values?.get(2)

        coords.text = "[$X,$Y,$Z]"

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}
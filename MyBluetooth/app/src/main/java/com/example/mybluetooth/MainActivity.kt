package com.example.mybluetooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var bluetoothAdapter: BluetoothAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        if (bluetoothAdapter == null) {
            Status.text = "Bluetooth does not exist!"
        } else {
            Status.text = "Bluetooth exist!"
        }

        ButOn.setOnClickListener {
            if (!bluetoothAdapter!!.isEnabled) {
                Toast.makeText(this, "Bluetooth was enable!", Toast.LENGTH_SHORT).show()

                startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 0)
            } else {
                Toast.makeText(this, "Bluetooth has been enable!", Toast.LENGTH_SHORT).show()
            }

            ButDiscoverable.setOnClickListener {
                if (!bluetoothAdapter!!.isDiscovering()) {
                    Toast.makeText(
                        this,
                        "You do make your device visible to other device!",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE), 1)
                }
            }

            ButOff.setOnClickListener {
                if (bluetoothAdapter!!.isEnabled) {

                    bluetoothAdapter!!.disable()
                    Toast.makeText(this, "Bluetooth disabling...", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Bluetooth has been disable!!", Toast.LENGTH_SHORT).show()
                }
            }

            ButPaired.setOnClickListener {
                if (bluetoothAdapter!!.isEnabled()) {
                    Paired.text = "Paired devices: "

                    for (device: BluetoothDevice in bluetoothAdapter!!.bondedDevices) {
                        Paired.append("""Device: ${device.name}, $device """.trimIndent())
                    }
                } else {
                    Toast.makeText(this, "Device can`t found paired devices!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
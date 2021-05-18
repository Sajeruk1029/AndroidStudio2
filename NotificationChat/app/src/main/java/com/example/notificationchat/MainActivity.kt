package com.example.notificationchat

import android.app.Notification
import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

import java.lang.Exception
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket

class MainActivity : AppCompatActivity(){

    var server_socket : ServerSocket? = null
    var dataInputStream : DataInputStream? = null
    var sock : Socket? = null
    var notificationManager : NotificationManager? = null

    var notificationCompat : NotificationCompat.Builder? = null
    var notification : Notification? = null

    var msg : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(Runnable {
            run() {

                var bufferedReader : BufferedReader? = null

                try {
                    server_socket = ServerSocket(1234)

                    Log.w("DEBUG_PTHREAD", "YES1")
                } catch (exepetion: Exception) {
                    Toast.makeText(
                        this,
                        "Exception create server socket: ${exepetion.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Runnable
                    Log.w("DEBUG_PTHREAD", "NO1")
                }

                Log.w("DEBUG_PTHREAD", "YES2")

                while (true) {
                    Log.w("DEBUG_PTHREAD", "YES3")
                    sock = server_socket!!.accept()

                    bufferedReader = BufferedReader(InputStreamReader(sock!!.getInputStream()))

                    Log.w("DEBUG_PTHREAD", "YES4")
                    dataInputStream = DataInputStream(sock!!.getInputStream())
                    Log.w("DEBUG_PTHREAD", "YES5")
                    //Thread(Runnable {
                        msg = bufferedReader!!.readLine()
                    //}).join()

                    Log.w("DEBUG_PTHREADrrrr", msg + "TYT")

                    notificationCompat =
                        NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Title")
                            .setContentText(msg.toString())
                    Log.w("DEBUG_PTHREAD", "YES6")

                    notification = notificationCompat!!.build()
                    Log.w("DEBUG_PTHREAD", "YES7")

                    notificationManager =
                        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                    Log.w("DEBUG_PTHREAD", "YES8")

                    notificationManager!!.notify(1, notification)
                    Log.w("DEBUG_PTHREAD", "YES9")
                }
            }
        }).start()

        SendBut.setOnClickListener {

            var socket: Socket? = null
            var address : String = AddressLine.text.toString()
            var msg : String =  MSGLine.text.toString()
            var printWriter : PrintWriter? = null

            //Toast.makeText(this, MSGLine.text.toString(), Toast.LENGTH_SHORT).show()

            Log.w("DEBUG_PTHREAD", "YESS1")
            Log.w("DEBUG_PTHREADrrrr", msg)
            Thread(Runnable {
                run() {
                    Log.w("DEBUG_PTHREAD", "YESS2")
                    try {
                        //Thread(Runnable {
                            socket = Socket(address, 1234)
                        //}).join()

                        printWriter = PrintWriter(BufferedWriter(OutputStreamWriter(socket!!.getOutputStream())), true)

                        if (socket == null){
                            Toast.makeText(this, "YES1", Toast.LENGTH_SHORT).show()
                        }

                        Log.w("DEBUG_PTHREAD", "YESS3")

                    } catch (exception: Exception) {
                        Toast.makeText(
                            this,
                            "Exception open socket: ${exception.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@Runnable
                    }

                    if (socket == null){
                        Toast.makeText(this, "YES2", Toast.LENGTH_SHORT).show()
                    }

                    //if ((socket == null) || (!socket!!.isClosed)) {
                        //Toast.makeText(this, "Exception send data!", Toast.LENGTH_SHORT).show()
                        //return@Runnable
                    //} else {
                        try {
                            //Thread(Runnable {
                            printWriter!!.println(msg)
                            printWriter!!.flush()
                            //socket!!.getOutputStream().write(msg.toByteArray())
                                //socket!!.getOutputStream().flush()
                            //}).join()

                            Log.w("DEBUG_PTHREAD", "YESS4")

                            if (socket == null){
                                Toast.makeText(this, "YES3", Toast.LENGTH_SHORT).show()
                            }

                        } catch (exception: Exception) {
                            Toast.makeText(
                                this,
                                "Exception send data: ${exception.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        //}
                    }

                    if (socket == null){
                        Toast.makeText(this, "YES4", Toast.LENGTH_SHORT).show()
                    }

                    //if ((socket != null) && (!socket!!.isClosed)) {
                        try {
                            if (socket!!.isClosed){
                               Toast.makeText(this, "YES", Toast.LENGTH_SHORT).show()
                               return@run
                            }
                            printWriter!!.close()
                            socket!!.close()
                            Log.w("DEBUG_PTHREAD", "YESS5")
                            socket = null;
                            Log.w("DEBUG_PTHREAD", "YESS6")
                        } catch (exeption: Exception) {
                            Toast.makeText(
                                this,
                                "Exception close socket: ${exeption.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.w("DEBUG_PTHREAD", exeption.stackTraceToString())
                        //}
                    }
                }
            }).start()
        }
    }
}

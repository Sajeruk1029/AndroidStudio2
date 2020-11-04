package com.example.unittest

import android.util.Log
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import kotlin.concurrent.thread

class FirstTest(url : String) {

    private var result : String = ""
    private lateinit var res : Response

    init{
        val httpclient : OkHttpClient = OkHttpClient()
        val request : Request = Request.Builder().url(url).build()

        httpclient.newCall(request).enqueue(object : Callback
        {
            override fun onFailure(call: Call, e: IOException) {
                result = "Error!"
                Log.d("Debug", result)
            }

            override fun onResponse(call: Call, response: Response) {
                //result = (JSONObject(response!!.body()!!.string()).getJSONArray("articles").getJSONObject(0).get("author")).toString()
                res = response
                Log.d("Debug", result)
            }
        })
    }

    fun get_result() : String
    {
        //while (result == ""){ print("ddddd")}
        Thread.sleep(10000)

        result = res.body()!!.string()
        result = result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1)
        return result
    }
}
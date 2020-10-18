package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

    }

    fun onClick(view : View) {
        val builder: Retrofit.Builder = Retrofit.Builder().baseUrl("https://api.icndb.com/ ")
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit: Retrofit = builder.build()
        val interfacedata: DataInterface = retrofit.create<DataInterface>(DataInterface::class.java)
        val call: retrofit2.Call<Data> = interfacedata.getJoke()

        val builder2 : Retrofit.Builder = Retrofit.Builder().baseUrl("http://www.dev2qa.com/demo/").addConverterFactory(GsonConverterFactory.create())
        val retrofit2 : Retrofit = builder2.build()
        val interfacedata2 : DataInterface = retrofit2.create<DataInterface>(DataInterface::class.java)
        val call2 : retrofit2.Call<ResponseBody> = interfacedata2.getPost("test", "test", "test@test.test")

        val response: Response<Data> = call.execute()
        val response2 : Response<ResponseBody> = call2.execute()

        if (response.isSuccessful) {
            textView.text = response.body()?.objectWithJoke?.joke
        }
        else{
            textView.text = "Error!"
        }

        if (response2.isSuccessful) {
            textView2.text = "Success!"
        }
        else{
            textView2.text = "Error!"
        }

    }

}
package com.example.retrofit

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface DataInterface {
    @GET("/jokes/random")
    fun getJoke() : Call<Data>

    @POST("user/register.html")
    @FormUrlEncoded
    fun getPost(@Field("userName") userName : String, @Field("password") password : String, @Field("email") email : String) : Call<ResponseBody>

}
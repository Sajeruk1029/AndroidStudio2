package com.example.mynewssmarttv

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class News(url : String) {

    private var listAuthor : MutableList<String> = mutableListOf()
    private var listContents : MutableList<String> = mutableListOf()
    private var listUrlsOfImage : MutableList<String> = mutableListOf()
    private var listTitles : MutableList<String> = mutableListOf()

    private var countNews : Int = 0

    init{
        val httpClient : OkHttpClient = OkHttpClient()
        val request : Request = Request.Builder().url(url).build()

        val response : Response = httpClient.newCall(request).execute()

        var json : String = ""

        if(response.isSuccessful) {
            json = response.body!!.string()
        }
        else {
            json = "{'articles': [{'author': null, 'title': null, 'urlToImage': null, 'content': null}]}"
        }

        /*httpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                json = "{'articles': [{'author': null, 'title': null, 'urlToImage': null, 'content': null}]}"
            }

            override fun onResponse(call: Call, response: Response) {
                json = response.body!!.string()
            }
        })

        //val json : String = response.body!!.string()

        while(json == "") { }
*/
        Log.d("Debug", json)

        val count : Int = (JSONObject(json).getJSONArray("articles").length())

        for(count2 in 1..count)
        {
            listAuthor.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("author").toString())
            listContents.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("content").toString())
            listUrlsOfImage.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("urlToImage").toString())
            listTitles.add((JSONObject(json).getJSONArray("articles").getJSONObject(count2 - 1)).get("title").toString())
        }

        countNews = count
    }

    fun getCountNews() : Int {
        return countNews
    }

    fun getListTitleNews() : MutableList<String> {
        return listTitles
    }

    fun getListAuhorsNews() : MutableList<String> {
        return listAuthor
    }

    fun getListUrlsOfImageNews() : MutableList<String> {
        return listUrlsOfImage
    }

    fun getListContentNews() : MutableList<String> {
        return listContents
    }

    fun getTitleNews(index : Int) : String{
        return listTitles.get(index)
    }

    fun getAuthorNews(index : Int) : String{
        return listAuthor.get(index)
    }

    fun getUrlToImageNews(index : Int) : String{
        return listUrlsOfImage.get(index)
    }

    fun getContentNews(index : Int) : String{
        return listContents.get(index)
    }
}
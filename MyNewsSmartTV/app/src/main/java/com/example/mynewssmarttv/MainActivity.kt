package com.example.mynewssmarttv

import android.os.Bundle
import android.os.StrictMode
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val news : News = News("http://newsapi.org/v2/top-headlines?country=us&apiKey=bc62f7ad76fb4ac6b5f4542b18ad8507")

        val items : MutableList<ModelData> = mutableListOf()

        for(count in 1..news.getCountNews())
        {
            items.add(ModelData(news.getTitleNews(count - 1), news.getUrlToImageNews(count - 1), news.getAuthorNews(count - 1), news.getContentNews(count - 1)))
        }

        Recycler.layoutManager  = LinearLayoutManager(this)
        Recycler.setHasFixedSize(true)
        Recycler.adapter = RecyclerAdapter(items)

    }
}
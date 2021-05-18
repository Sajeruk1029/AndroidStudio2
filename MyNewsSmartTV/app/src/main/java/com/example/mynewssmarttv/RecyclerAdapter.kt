package com.example.mynewssmarttv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
//import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(val item : MutableList<ModelData>) : RecyclerView.Adapter<RecyclerAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.onedataelement, parent, false))

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: RecyclerAdapter.MainHolder, position: Int) {
        holder.bind(item.get(position))
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val ImageNews : ImageView = itemView.findViewById(R.id.ImageNews)
        private val TitleNews : TextView = itemView.findViewById(R.id.TitleNews)
        private val ContentNews : TextView = itemView.findViewById(R.id.ContentNews)
        private val AuthorNews : TextView = itemView.findViewById(R.id.AuthorNews)

        fun bind(item : ModelData) {
            Picasso.get().load(item.urlToImage).fit().placeholder(R.mipmap.black).error(R.mipmap.black).into(ImageNews)
            TitleNews.text = "Title: " + item.title
            ContentNews.text = "Content: " + item.content
            AuthorNews.text = "Author: " + item.author
        }

    }

}
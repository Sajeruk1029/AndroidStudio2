package com.example.mynewssmarttv

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelData(val title : String, val urlToImage : String, val author : String, val content : String) : Parcelable
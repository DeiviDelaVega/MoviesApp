package com.dev.moviesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoDataResponse(
    @SerializedName("id")
    val id: Int,
    val results: List<MoviesVideo>
)

data class MoviesVideo(
    @SerializedName("id")
    val id: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("type")
    val type: String
)
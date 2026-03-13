package com.dev.moviesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoDataResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("results")
    var result: List<MoviesVideo>
)
data class MoviesDetailsDTO(
    @SerializedName("id")
    var id : Int,
    @SerializedName("original_title")
    var title : String,
    @SerializedName("release_date")
    var subTitle : String,
    @SerializedName("poster_path")
    var image : String,
    @SerializedName("vote_average")
    var rating : Double,
    @SerializedName("overview")
    var synopsis : String,
    @SerializedName("video")
    var video : Boolean
)

data class MoviesVideo(
    @SerializedName("key")
    var video : String
)
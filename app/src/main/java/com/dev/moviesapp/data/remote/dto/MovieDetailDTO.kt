package com.dev.moviesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("overview")
    val synopsis: String,
    @SerializedName("video")
    val video: Boolean
)
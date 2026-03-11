package com.dev.moviesapp.data.remote.dto

import com.google.gson.annotations.SerializedName


data class MoviesDataResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var result: List<MoviesDTO>
)

data class MoviesDTO(
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var title: String,
    @SerializedName("release_date")
    var subTitle: String,
    @SerializedName("poster_path")
    var image: String,
    @SerializedName("vote_average")
    var rating: Double,
)

object MovieMock {
    val movieList = listOf(
        MoviesDTO(1, "Inception", "Sci-Fi", "https://cataas.com/cat", 3.4),
        MoviesDTO(2, "The Dark Knight", "Action", "https://cataas.com/cat", 3.4),
        MoviesDTO(3, "Interstellar", "Adventure", "https://cataas.com/cat", 3.4),
        MoviesDTO(4, "Interstellar", "Adventure", "https://cataas.com/cat/sleep", 3.4),
        MoviesDTO(5, "Interstellar", "Adventure", "https://cataas.com/cat", 3.4),
        MoviesDTO(6, "Interstellar", "Adventure", "https://cataas.com/cat/sleep", 3.4),
        MoviesDTO(7, "Interstellar", "Adventure", "https://cataas.com/cat", 3.4),
        MoviesDTO(8, "Interstellar", "Adventure", "https://cataas.com/cat/sleep", 3.4)
    )
}
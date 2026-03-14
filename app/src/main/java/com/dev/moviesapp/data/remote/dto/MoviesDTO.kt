package com.dev.moviesapp.data.remote.dto

import com.google.gson.annotations.SerializedName


data class MoviesDataResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoviesDTO>
)

data class MoviesDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double
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
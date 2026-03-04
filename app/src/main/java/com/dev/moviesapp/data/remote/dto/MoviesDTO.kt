package com.dev.moviesapp.data.remote.dto

data class MoviesDTO(
    var id : Int,
    var title : String,
    var subTitle : String,
    var image : String,
    var rating : Double,
)
object MovieMock {
    val movieList = listOf(
        MoviesDTO(1, "Inception", "Sci-Fi", "https://cataas.com/cat", 3.4),
        MoviesDTO(2, "The Dark Knight", "Action", "https://cataas.com/cat", 3.4),
        MoviesDTO(3, "Interstellar", "Adventure", "https://cataas.com/cat", 3.4),
        MoviesDTO(4, "Interstellar", "Adventure", "https://cataas.com/cat", 3.4)
    )
}
package com.dev.moviesapp.data.remote.api

import com.dev.moviesapp.data.remote.dto.MoviesDataResponse
import com.dev.moviesapp.data.remote.dto.MoviesDetailsDTO
import com.dev.moviesapp.data.remote.dto.VideoDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("pelicula/popular")
    suspend fun listMovies() : Response<MoviesDataResponse>

    @GET("movie/{movie_id}")
    suspend fun detailsMovies(@Path("movie_id") movieId : Int) : MoviesDetailsDTO

    @GET("{movie_id}/videos")
    suspend fun videoMovieId(@Path("movie_id") movieId : Int): Response<VideoDataResponse>
}
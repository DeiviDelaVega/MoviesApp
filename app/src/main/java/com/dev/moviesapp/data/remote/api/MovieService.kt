package com.dev.moviesapp.data.remote.api

import com.dev.moviesapp.data.remote.dto.MoviesDataResponse
import com.dev.moviesapp.data.remote.dto.MoviesDetailsDTO
import com.dev.moviesapp.data.remote.dto.VideoDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies() : Response<MoviesDataResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId : Int) : Response<MoviesDetailsDTO>

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path("movie_id") movieId : Int): Response<VideoDataResponse>
}
package com.dev.moviesapp.domain.repository

import com.dev.moviesapp.domain.model.Video

interface VideoRepository {
    suspend fun getMovieVideos(movieId: Int): Result<List<Video>>
}
package com.dev.moviesapp.domain.repository

import com.dev.moviesapp.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    fun getMovieDetail(movieId: Int): Flow<MovieDetail?>

    suspend fun syncMovieDetail(movieId: Int): Result<Unit>
}
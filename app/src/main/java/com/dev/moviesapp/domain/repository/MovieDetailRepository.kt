package com.dev.moviesapp.domain.repository

import com.dev.moviesapp.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    suspend fun insertMovie(movieDetail: MovieDetail): Result<Unit>
    fun getMovieDetail(movieId: Int): Flow<MovieDetail?>
}
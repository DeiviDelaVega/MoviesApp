package com.dev.moviesapp.domain.repository

import com.dev.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getAllMovies() : Flow<List<Movie>>
    suspend fun insertMovies(movies: List<Movie>) : Result<Unit>
}
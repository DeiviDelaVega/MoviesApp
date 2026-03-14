package com.dev.moviesapp.domain.usecase.movie

import com.dev.moviesapp.domain.model.Movie
import com.dev.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Flow<List<Movie>> =
        movieRepository.getAllMovies()
}
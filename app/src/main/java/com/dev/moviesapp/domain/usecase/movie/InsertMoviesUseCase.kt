package com.dev.moviesapp.domain.usecase.movie

import com.dev.moviesapp.domain.model.Movie
import com.dev.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class InsertMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movies: List<Movie>): Result<Unit> =
        movieRepository.insertMovies(movies)
}
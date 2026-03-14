package com.dev.moviesapp.domain.usecase.movie

import com.dev.moviesapp.domain.model.Movie
import com.dev.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Result<List<Movie>> = movieRepository.getAllMovies()
}
package com.dev.moviesapp.domain.usecase.movie

import com.dev.moviesapp.domain.repository.MovieRepository
import javax.inject.Inject

class SyncMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke() = movieRepository.syncMovies()
}
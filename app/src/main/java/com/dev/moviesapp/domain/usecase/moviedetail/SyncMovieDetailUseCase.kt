package com.dev.moviesapp.domain.usecase.moviedetail

import com.dev.moviesapp.domain.repository.MovieDetailRepository
import javax.inject.Inject

class SyncMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    suspend operator fun invoke(movieId: Int): Result<Unit> =
        movieDetailRepository.syncMovieDetail(movieId)
}
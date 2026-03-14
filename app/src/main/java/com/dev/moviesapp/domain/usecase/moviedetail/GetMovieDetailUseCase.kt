package com.dev.moviesapp.domain.usecase.moviedetail

import com.dev.moviesapp.domain.model.MovieDetail
import com.dev.moviesapp.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    operator fun invoke(movieId: Int) : Flow<MovieDetail?> = movieDetailRepository.getMovieDetail(movieId)
}
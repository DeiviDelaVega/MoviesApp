package com.dev.moviesapp.domain.usecase.moviedetail

import com.dev.moviesapp.domain.model.MovieDetail
import com.dev.moviesapp.domain.repository.MovieDetailRepository
import javax.inject.Inject

class InsertMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    suspend operator fun invoke(movie: MovieDetail) : Result<Unit> = movieDetailRepository.insertMovie(movie)
}
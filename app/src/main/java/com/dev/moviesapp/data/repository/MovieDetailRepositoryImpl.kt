package com.dev.moviesapp.data.repository

import com.dev.moviesapp.data.local.dao.MovieDetailDao
import com.dev.moviesapp.data.mapper.toDomain
import com.dev.moviesapp.data.mapper.toEntity
import com.dev.moviesapp.data.remote.api.MovieService
import com.dev.moviesapp.domain.model.MovieDetail
import com.dev.moviesapp.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val movieDetailDao: MovieDetailDao,
    private val movieService: MovieService
) : MovieDetailRepository {

    override fun getMovieDetail(movieId: Int): Flow<MovieDetail?> {
        return movieDetailDao.getMovieDetail(movieId).map {
            it?.toDomain()
        }
    }

    override suspend fun syncMovieDetail(movieId: Int): Result<Unit> {
        return try {
            val response = movieService.getMovieDetail(movieId)
            movieDetailDao.insertMovie(response.toEntity())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
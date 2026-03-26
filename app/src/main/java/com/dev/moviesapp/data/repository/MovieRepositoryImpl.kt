package com.dev.moviesapp.data.repository

import androidx.work.WorkManager
import com.dev.moviesapp.data.local.dao.MovieDao
import com.dev.moviesapp.data.mapper.toDomain
import com.dev.moviesapp.data.mapper.toEntity
import com.dev.moviesapp.data.worker.SyncWorker
import com.dev.moviesapp.domain.model.Movie
import com.dev.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val workManager: WorkManager
) : MovieRepository {

    override fun getAllMovies(): Flow<List<Movie>> {
        return movieDao.getAllMovies().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertMovies(movies: List<Movie>): Result<Unit> {
        return try {
            val entities = movies.map { it.toEntity() }
            movieDao.insertMovies(entities)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun syncMovies() {
        SyncWorker.enqueue(workManager)
    }
}
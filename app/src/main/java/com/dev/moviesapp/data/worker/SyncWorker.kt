package com.dev.moviesapp.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.dev.moviesapp.data.local.dao.MovieDao
import com.dev.moviesapp.data.mapper.toEntity
import com.dev.moviesapp.data.remote.api.MovieService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val movieDao: MovieDao,
    private val apiService: MovieService
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val response = apiService.getPopularMovies()

            if (response.isSuccessful) {
                val movies = response.body()?.results ?: emptyList()
                movieDao.insertMovies(
                    movies.map { it.toEntity() }
                )
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: Exception) {
            Result.retry()
        }
    }

    companion object {
        fun enqueue(workerManager: WorkManager) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val request = OneTimeWorkRequestBuilder<SyncWorker>()
                .setConstraints(constraints)
                .build()

            workerManager.enqueue(request)
        }
    }
}
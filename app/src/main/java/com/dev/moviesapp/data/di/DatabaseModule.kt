package com.dev.moviesapp.data.di

import android.content.Context
import androidx.room.Room
import com.dev.moviesapp.data.local.dao.MovieDao
import com.dev.moviesapp.data.local.dao.MovieDetailDao
import com.dev.moviesapp.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "MOVIES_DB").build()

    @Provides
    @Singleton
    fun provideMovieDao(db: AppDatabase): MovieDao {
        return db.movieDao()
    }

    @Provides
    @Singleton
    fun provideMovieDetailDao(db: AppDatabase): MovieDetailDao {
        return db.movieDetailDao()
    }
}
package com.dev.moviesapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.moviesapp.data.local.dao.MovieDao
import com.dev.moviesapp.data.local.dao.MovieDetailDao
import com.dev.moviesapp.data.local.entity.MovieDetailEntity
import com.dev.moviesapp.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class, MovieDetailEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieDetailDao(): MovieDetailDao
}
package com.dev.moviesapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_detail")
data class MovieDetailEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val subTitle: String,
    val image: String,
    val rating: Double,
    val synopsis: String,
)
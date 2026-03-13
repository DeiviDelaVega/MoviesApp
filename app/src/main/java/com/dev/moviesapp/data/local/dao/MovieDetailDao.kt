package com.dev.moviesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.dev.moviesapp.data.local.entity.MovieEntity
/**
 * DAO que gestiona el acceso a la tabla de películas en Room.
 *
 * Fuente de verdad en la estrategia Offline First: la UI siempre
 * consume datos desde Room, nunca directamente desde la API.
 *
 *  - insertMovie:  Persiste una película individual (detalle).
 */
@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntity: MovieEntity)
}
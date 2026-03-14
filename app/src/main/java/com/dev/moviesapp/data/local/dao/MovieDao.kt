package com.dev.moviesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dev.moviesapp.data.local.entity.MovieDetailEntity
import com.dev.moviesapp.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow
/**
 * DAO que gestiona el acceso a la tabla de películas en Room.
 *
 * Fuente de verdad en la estrategia Offline First: la UI siempre
 * consume datos desde Room, nunca directamente desde la API.
 *
 *  - getAllMovies:  Expone la tabla como Flow para reactividad automática.
 *  - insertMovie:  Persiste una película individual (detalle).
 *  - insertMovies: Persiste la lista completa (populares) en una sola transacción.
 */
@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies() : Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)
}
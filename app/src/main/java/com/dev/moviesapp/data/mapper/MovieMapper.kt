package com.dev.moviesapp.data.mapper

import com.dev.moviesapp.data.local.entity.MovieEntity
import com.dev.moviesapp.data.remote.dto.MoviesDTO
import com.dev.moviesapp.domain.model.Movie

fun MoviesDTO.toEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        title = this.originalTitle,
        subTitle = this.releaseDate,
        image = this.posterPath,
        rating = this.voteAverage
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        subTitle = this.subTitle,
        image = this.image,
        rating = this.rating
    )
}

fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        title = this.title,
        subTitle = this.subTitle,
        image = this.image,
        rating = this.rating
    )
}
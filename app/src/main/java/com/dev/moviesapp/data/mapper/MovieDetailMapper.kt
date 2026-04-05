package com.dev.moviesapp.data.mapper

import com.dev.moviesapp.data.local.entity.MovieDetailEntity
import com.dev.moviesapp.data.remote.dto.MovieDetailDTO
import com.dev.moviesapp.domain.model.MovieDetail

fun MovieDetailEntity.toDomain(): MovieDetail {
    return MovieDetail(
        id = this.id,
        title = this.title,
        subTitle = this.subTitle,
        image = this.image,
        rating = this.rating,
        synopsis = this.synopsis
    )
}

fun MovieDetailDTO.toEntity(): MovieDetailEntity {
    return MovieDetailEntity(
        id = this.id,
        title = this.title,
        subTitle = this.releaseDate,
        image = this.posterPath,
        rating = this.voteAverage,
        synopsis = this.synopsis
    )
}
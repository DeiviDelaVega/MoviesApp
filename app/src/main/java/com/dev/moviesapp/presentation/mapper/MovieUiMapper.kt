package com.dev.moviesapp.presentation.mapper

import com.dev.moviesapp.domain.model.Movie
import com.dev.moviesapp.domain.model.MovieDetail
import com.dev.moviesapp.presentation.ui.model.MovieDetailUi
import com.dev.moviesapp.presentation.ui.model.MovieUi

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

fun Movie.toUiModel() = MovieUi(
    id = id,
    title = title,
    overview = subTitle,
    posterUrl = "$IMAGE_BASE_URL$image",
    rating = String.format("%.1f ★", rating)
)

fun MovieDetail.toUiModel() = MovieDetailUi(
    id = id,
    title = title,
    subTitle = subTitle,
    image = "$IMAGE_BASE_URL$image",
    rating = String.format("%.1f ★", rating),
    synopsis = synopsis
)
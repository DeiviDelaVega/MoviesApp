package com.dev.moviesapp.presentation.mapper

import com.dev.moviesapp.domain.model.Movie
import com.dev.moviesapp.presentation.ui.model.MovieUiModel

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

fun Movie.toUiModel() = MovieUiModel(
    id = id,
    title = title,
    overview = subTitle,
    posterUrl = "$IMAGE_BASE_URL$image",
    rating = String.format("%.1f ★", rating)
)
package com.dev.moviesapp.presentation.ui.model

data class MovieUiModel(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val rating: String
)
package com.dev.moviesapp.presentation.ui.navigation

import kotlinx.serialization.Serializable

@Serializable data object Home : Route
@Serializable data class Detail(val movieId: Int) : Route

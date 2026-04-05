package com.dev.moviesapp.presentation.ui.movies.details

import com.dev.moviesapp.presentation.ui.model.MovieDetailUi

sealed class MovieDetailsUiState {
    data object Loading : MovieDetailsUiState()
    data object Empty : MovieDetailsUiState()
    data class Success(val movieDetail: MovieDetailUi) : MovieDetailsUiState()
    data class Error(val message: String) : MovieDetailsUiState()
}
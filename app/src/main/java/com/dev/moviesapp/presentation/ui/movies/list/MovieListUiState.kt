package com.dev.moviesapp.presentation.ui.movies.list

import com.dev.moviesapp.presentation.ui.model.MovieUi

sealed class MovieListUiState {
    data object Loading : MovieListUiState()
    data object Empty : MovieListUiState()
    data class Success(val movies: List<MovieUi>) : MovieListUiState()
    data class Error(val message: String) : MovieListUiState()
}
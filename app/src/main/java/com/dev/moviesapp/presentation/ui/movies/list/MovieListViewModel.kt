package com.dev.moviesapp.presentation.ui.movies.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.moviesapp.domain.usecase.movie.GetAllMoviesUseCase
import com.dev.moviesapp.domain.usecase.movie.InsertMoviesUseCase
import com.dev.moviesapp.domain.usecase.movie.SyncMovieUseCase
import com.dev.moviesapp.presentation.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val syncMovieUseCase: SyncMovieUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieListUiState>(MovieListUiState.Loading)
    val uiState: StateFlow<MovieListUiState> = _uiState.asStateFlow()

    init {
        syncMovieUseCase()
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            getAllMoviesUseCase()
                .catch { _uiState.value = MovieListUiState.Error(it.message ?: "Unknown error") }
                .collect { movies ->
                    _uiState.value = if (movies.isEmpty()) {
                        MovieListUiState.Empty
                    } else {
                        MovieListUiState.Success(movies.map { it.toUiModel() })
                    }
                }
        }
    }
}
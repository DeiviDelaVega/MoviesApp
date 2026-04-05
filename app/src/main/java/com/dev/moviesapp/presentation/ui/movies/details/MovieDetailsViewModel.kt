package com.dev.moviesapp.presentation.ui.movies.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.moviesapp.domain.usecase.moviedetail.GetMovieDetailUseCase
import com.dev.moviesapp.domain.usecase.moviedetail.SyncMovieDetailUseCase
import com.dev.moviesapp.presentation.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val syncMovieDetailUseCase: SyncMovieDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)
    val uiState: StateFlow<MovieDetailsUiState> = _uiState.asStateFlow()

    fun loadMovieDetail(movieId: Int) {
        syncMovieDetail(movieId)
        movieDetail(movieId)
    }

    private fun syncMovieDetail(movieId: Int) {
        viewModelScope.launch {
            syncMovieDetailUseCase(movieId)
        }
    }

    private fun movieDetail(movieId: Int) {
        viewModelScope.launch {
            getMovieDetailUseCase(movieId)
                .catch { _uiState.value = MovieDetailsUiState.Error(it.message ?: "Unknown error") }
                .collect { movieDetail ->
                    _uiState.value = if (movieDetail != null)
                        MovieDetailsUiState.Success(movieDetail.toUiModel())
                    else
                        MovieDetailsUiState.Empty
                }
        }
    }
}
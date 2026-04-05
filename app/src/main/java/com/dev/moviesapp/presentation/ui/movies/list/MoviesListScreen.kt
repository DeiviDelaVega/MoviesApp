package com.dev.moviesapp.presentation.ui.movies.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.moviesapp.R
import com.dev.moviesapp.presentation.common.colorBackground
import com.dev.moviesapp.presentation.ui.movies.list.components.MoviesCard
import com.dev.moviesapp.presentation.ui.theme.jakartaFamily
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dev.moviesapp.presentation.ui.model.MovieUi
import com.dev.moviesapp.presentation.ui.movies.list.components.ModernSearchBar

@Composable
fun MoviesListScreen(
    onClick: (Int) -> Unit,
    viewModel: MovieListViewModel = hiltViewModel()
) {

    val addPlayerUiState by viewModel.uiState.collectAsStateWithLifecycle()

    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .colorBackground()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            contentAlignment = Alignment.TopCenter

        ) {
            Text(
                text = stringResource(R.string.title_movie_list),
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 22.dp),

                fontFamily = jakartaFamily,
                fontWeight = FontWeight.Bold
            )
        }

        ModernSearchBar(
            query = query,
            onQueryChange = { query = it }
        )

        Text(
            text = stringResource(R.string.sub_title_movie_list),
            fontSize = 22.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 28.dp, start = 22.dp, bottom = 8.dp),

            fontFamily = jakartaFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        when (val state = addPlayerUiState) {
            is MovieListUiState.Loading -> LoadingView()
            is MovieListUiState.Empty -> EmptyView()
            is MovieListUiState.Error -> ErrorView(state.message)
            is MovieListUiState.Success -> CardMoviesList(
                state.movies,
                onClick = onClick
            )
        }
    }
}

@Composable
fun CardMoviesList(
    movieList: List<MovieUi>,
    onClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieList) { item ->
            MoviesCard(
                item,
                onMovieClick = { onClick(item.id) }
            )
        }
    }
}

@Composable
fun EmptyView() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(6) {
            MoviesCardShimmer()
        }
    }
}

@Composable
fun LoadingView() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(6) {
            MoviesCardShimmer()
        }
    }
}

@Composable
fun ErrorView(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "⚠️",
                fontSize = 48.sp
            )
            Text(
                text = message,
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = jakartaFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewMovieList() {
    MoviesListScreen(
        onClick = {},
        viewModel = hiltViewModel()
    )
}
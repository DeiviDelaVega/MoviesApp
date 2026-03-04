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
import com.dev.moviesapp.data.remote.dto.MovieMock
import com.dev.moviesapp.presentation.common.colorBackground
import com.dev.moviesapp.presentation.ui.movies.list.components.MoviesCard
import com.dev.moviesapp.presentation.ui.theme.jakartaFamily
import androidx.compose.foundation.lazy.grid.items

@Composable
fun MoviesListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .colorBackground()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = stringResource(R.string.title_movie_list),
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 18.dp),
                fontFamily = jakartaFamily,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = stringResource(R.string.sub_title_movie_list),
            fontSize = 22.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp),
            fontFamily = jakartaFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )

        CardMoviesList()
    }
}

@Composable
fun CardMoviesList() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(MovieMock.movieList) { item ->
            MoviesCard(
                image = item.image,
                rating = item.rating,
                title = item.title,
                subTitle = item.subTitle
            )
        }
    }
}

@Preview
@Composable
fun PreviewMovieList() {
    MoviesListScreen()
}
package com.dev.moviesapp.presentation.ui.movies.details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dev.moviesapp.R

@Composable
fun MoviesDetailCard(
    image: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .width(160.dp)
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier.size(height = 240.dp, width = 180.dp),
            colors = CardDefaults.cardColors(Color.White),
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = image,
                    contentDescription = "Movie image",
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewMovieCard() {
    MoviesDetailCard(
        "dsdsddsd",
        modifier = Modifier
    )
}
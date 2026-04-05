package com.dev.moviesapp.presentation.ui.movies.list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.dev.moviesapp.R
import com.dev.moviesapp.presentation.ui.model.MovieUi
import com.dev.moviesapp.presentation.ui.theme.jakartaFamily

@Composable
fun MoviesCard(
    movie : MovieUi,
    onMovieClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier.size(height = 240.dp, width = 180.dp),
            colors = CardDefaults.cardColors(Color.White),
            onClick = onMovieClick
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = movie.posterUrl,
                    contentDescription = "Movie image",
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                )

                OutlinedCard(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(width = 45.dp, height = 24.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Gray.copy(alpha = 0.4f)
                    ),
                    border = BorderStroke(0.5.dp, Color.Black)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.estrella_icon),
                            contentDescription = "Star icon",
                            modifier = Modifier.size(10.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = movie.rating,
                            color = Color.White,
                            style = TextStyle(
                                fontFamily = jakartaFamily,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }

            }
        }

        Text(
            text = movie.title,
            fontSize = 16.sp,
            color = Color.White,
            fontFamily = jakartaFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = movie.overview,
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = jakartaFamily,
            fontWeight = FontWeight.Normal,
        )
    }
}
//
//@Preview
//@Composable
//fun PreviewMovieCard() {
//    MoviesCard(MoviesDTO(
//        1,"https://cataas.com/cat", "Sci-Fi", "Interestelar", 3.4
//    ))
//}
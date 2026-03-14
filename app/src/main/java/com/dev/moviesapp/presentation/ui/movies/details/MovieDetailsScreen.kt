package com.dev.moviesapp.presentation.ui.movies.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.moviesapp.presentation.common.colorBackground
import com.dev.moviesapp.presentation.ui.movies.details.components.CircularImageWithBackground
import com.dev.moviesapp.R
import com.dev.moviesapp.data.remote.dto.MoviesDetailsDTO
import com.dev.moviesapp.presentation.ui.movies.details.components.ButtonWatchVideo
import com.dev.moviesapp.presentation.ui.movies.details.components.MoviesDetailCard
import com.dev.moviesapp.presentation.ui.theme.circleBlue
import com.dev.moviesapp.presentation.ui.theme.jakartaFamily

@Composable
fun MovieDetailsScreen() {

    val moviesDetailsDTO = MoviesDetailsDTO(
        id = 1,
        title = "Inception",
        releaseDate = "Sci-Fi",
        posterPath = "https://cataas.com/cat",
        voteAverage = 3.4,
        synopsis = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        video = false
    )

    MovieDetails(moviesDetailsDTO = moviesDetailsDTO)
}

@Composable
fun MovieDetails(moviesDetailsDTO: MoviesDetailsDTO) {

    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .colorBackground()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .colorBackground()
                .verticalScroll(scrollState)
        ) {

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.background_detail_movie),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.BottomStart)
                        .offset(y = 60.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    MoviesDetailCard(
                        image = moviesDetailsDTO.posterPath,
                        modifier = Modifier.size(width = 140.dp, height = 210.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 10.dp)
                            .weight(1f)
                    ) {
                        Text(
                            text = moviesDetailsDTO.title,
                            color = Color.White,
                            fontSize = 28.sp,
                            fontFamily = jakartaFamily,
                            lineHeight = 34.sp
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "${moviesDetailsDTO.voteAverage}/10",
                                color = Color.LightGray,
                                fontSize = 18.sp,
                                fontFamily = jakartaFamily,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.estrella_icon),
                                contentDescription = "Rating star",
                                modifier = Modifier.size(16.dp),
                                tint = Color(0xFFFFD700)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(80.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Synopsis",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = jakartaFamily,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = moviesDetailsDTO.synopsis,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp,
                    fontFamily = jakartaFamily,
                    lineHeight = 24.sp,
                )
            }

            Spacer(modifier = Modifier.height(130.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
        ) {
            CircularImageWithBackground(
                imageId = R.drawable.left_date_icon,
                backgroundColor = circleBlue,
                modifier = Modifier.padding(20.dp),
                onClick = {}
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .colorBackground()
                .navigationBarsPadding()
                .drawWithContent {
                    drawContent()
                    drawLine(
                        color = Color.Gray.copy(alpha = 0.3f),
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 1.dp.toPx()
                    )
                }
                .padding(horizontal = 24.dp, vertical = 28.dp)
        ) {
            ButtonWatchVideo(
                onClick = {
                    val watch = moviesDetailsDTO.video
                    println(watch)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewMovieList() {
    MovieDetailsScreen()
}
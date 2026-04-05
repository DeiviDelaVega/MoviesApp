package com.dev.moviesapp.presentation.ui.movies.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.moviesapp.presentation.common.colorBackground
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun MovieDetailShimmer() {
    val shimmer = rememberShimmer(shimmerBounds = ShimmerBounds.Window)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .colorBackground()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .colorBackground()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .shimmer(shimmer)
                    .background(Color.Gray.copy(alpha = 0.3f))
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .offset(y = (-60).dp)
            ) {
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 140.dp, height = 210.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .shimmer(shimmer)
                            .background(Color.Gray.copy(alpha = 0.4f))
                    )

                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 10.dp)
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(28.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .shimmer(shimmer)
                                .background(Color.Gray.copy(alpha = 0.3f))
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .height(18.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .shimmer(shimmer)
                                .background(Color.Gray.copy(alpha = 0.3f))
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .shimmer(shimmer)
                        .background(Color.Gray.copy(alpha = 0.3f))
                )
                Spacer(modifier = Modifier.height(12.dp))

                repeat(5) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(if (it == 4) 0.6f else 1f)
                            .height(14.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .shimmer(shimmer)
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
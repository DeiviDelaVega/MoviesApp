package com.dev.moviesapp.presentation.ui.movies.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun MoviesCardShimmer() {
    val shimmer = rememberShimmer(shimmerBounds = ShimmerBounds.Window)

    Column(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(height = 240.dp, width = 180.dp)
                .clip(RoundedCornerShape(12.dp))
                .shimmer(shimmer)
                .background(Color.Gray.copy(alpha = 0.3f))
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(16.dp)
                .shimmer(shimmer)
                .background(Color.Gray.copy(alpha = 0.3f))
        )
        Spacer(modifier = Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(14.dp)
                .shimmer(shimmer)
                .background(Color.Gray.copy(alpha = 0.3f))
        )
    }
}
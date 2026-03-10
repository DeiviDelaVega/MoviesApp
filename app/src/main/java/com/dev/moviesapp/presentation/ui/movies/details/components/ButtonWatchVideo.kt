package com.dev.moviesapp.presentation.ui.movies.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.moviesapp.R
import com.dev.moviesapp.presentation.ui.theme.buttonWatchBlue
import com.dev.moviesapp.presentation.ui.theme.jakartaFamily

@Composable
fun ButtonWatchVideo(onClick: () -> Unit) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .size(width = 262.dp, height = 56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonWatchBlue,
            contentColor = Color.White
        )
    ) {
        Row {

            Icon(
                painter = painterResource(R.drawable.play_icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                "Watch Trailer",
                fontSize = 18.sp,
                fontFamily = jakartaFamily
            )
        }

    }
}

@Preview
@Composable
fun PreviewButtonWatchVideo() {
    ButtonWatchVideo(onClick = {})
}
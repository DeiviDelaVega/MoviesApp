package com.dev.moviesapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import com.dev.moviesapp.presentation.ui.theme.backgroundColor

fun Modifier.colorBackground(): Modifier {
    return this.background(
        color = backgroundColor
    )
}
package com.dev.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.dev.moviesapp.presentation.ui.movies.details.MovieDetailsScreen
import com.dev.moviesapp.presentation.ui.movies.list.MoviesListScreen
import com.dev.moviesapp.presentation.ui.navigation.Detail
import com.dev.moviesapp.presentation.ui.navigation.Home
import com.dev.moviesapp.presentation.ui.theme.MoviesAppTheme
import com.dev.moviesapp.utils.windowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        windowInsets(window)
        setContent {
            MoviesAppTheme {
                NavHost()
            }
        }
    }
}

@Composable
fun NavHost() {

    val backStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(rememberSaveableStateHolderNavEntryDecorator()),
        entryProvider = entryProvider {
            entry<Home> {
                MoviesListScreen(
                    onClick = { movieId ->
                        backStack.add(Detail(movieId))
                    }
                )
            }
            entry<Detail> { entry ->
                MovieDetailsScreen(entry.movieId)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesAppTheme {
    }
}
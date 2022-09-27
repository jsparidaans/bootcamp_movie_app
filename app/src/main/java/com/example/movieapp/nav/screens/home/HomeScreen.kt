package com.example.movieapp.nav.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.nav.MovieScreens
import com.example.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(modifier = Modifier, topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    movieList: List<Movie> = getMovies(),
    navController: NavController
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}

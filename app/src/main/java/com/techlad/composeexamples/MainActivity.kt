package com.techlad.composeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techlad.composeexamples.screens.MovieDetailScreen
import com.techlad.composeexamples.screens.MoviesListScreen
import com.techlad.composeexamples.ui.theme.ComposeExamplesTheme
import com.techlad.composeexamples.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeExamplesTheme {
                Surface(color = MaterialTheme.colors.background) {

                    //Navigation stuff
                    NavHost(navController = navController, startDestination = Screen.LIST.route) {
                        composable(route = Screen.LIST.route) {
                            MoviesListScreen(navController)
                        }
                        composable(route = Screen.DETAIL.route) {
                            val id = it.arguments?.getString("id")
                            id?.let { my_id -> MovieDetailScreen(my_id) }
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExamplesTheme {
        MoviesListScreen(rememberNavController())
    }
}

fun generateRandomText() : String = ('A'..'z').map { it }.shuffled().subList(0, 4).joinToString("")
package com.techlad.composeexamples.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techlad.composeexamples.utils.Screen

/**
 * Created by umair.khalid on 01,October,2021
 **/

@Composable
fun MoviesListScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(20) { item ->
            Button(
                onClick = {
                    navController.navigate(Screen.DETAIL.createRoute(id = item.toString()))
                }, modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 5.dp)
            ) {
                Text(
                    text = item.toString(),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
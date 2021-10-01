package com.techlad.composeexamples.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.techlad.composeexamples.HomeViewModel
import com.techlad.composeexamples.generateRandomText
import timber.log.Timber

/**
 * Created by umair.khalid on 01,October,2021
 **/

@Composable
fun MovieDetailScreen(id: String, viewModel: HomeViewModel = hiltViewModel()) {

    var state: String by remember { mutableStateOf(generateRandomText()) }

    Timber.e("Recomposition is in process")

    LaunchedEffect(key1 = Unit) {
        viewModel.makeApiCall(id).join()
        Timber.e("Inside LaunchedEffect")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Detail Page For ID #$id",
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Random String -> $state",
            modifier = Modifier.padding(16.dp)
        )

        Button(onClick = { state = generateRandomText() }) {
            Text(
                text = "Make Some Changes"
            )
        }
    }
}
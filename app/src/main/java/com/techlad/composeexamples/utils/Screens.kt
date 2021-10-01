package com.techlad.composeexamples.utils

/**
 * Created by umair.khalid on 01,October,2021
 **/

sealed class Screen(val route: String) {
    object LIST: Screen("movies")
    object DETAIL: Screen("movie/{id}") {
        fun createRoute(id: String) = "movie/$id"
    }
}
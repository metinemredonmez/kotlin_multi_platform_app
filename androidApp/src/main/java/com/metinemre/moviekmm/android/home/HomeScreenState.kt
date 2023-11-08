package com.metinemre.moviekmm.android.home

import com.metinemre.moviekmm.domain.model.Movie

data class HomeScreenState(
    var loading :Boolean = false,
    var refreshing : Boolean = false,
    var movies : List<Movie> = listOf(),
    var errorMessage : String? = null,
    var loadFinished : Boolean = false
)

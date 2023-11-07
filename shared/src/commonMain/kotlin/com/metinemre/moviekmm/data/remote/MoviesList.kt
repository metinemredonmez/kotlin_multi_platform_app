package com.metinemre.moviekmm.data.remote

import kotlinx.serialization.Serializable

// burada ise liste alacaz tek filmlerin listesi popular filmler için
@Serializable
internal data class MoviesList (
    val results :List<MovieSingle>
)
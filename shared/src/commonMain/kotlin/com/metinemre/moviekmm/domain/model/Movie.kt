package com.metinemre.moviekmm.domain.model

import kotlinx.serialization.SerialName

data class Movie (
    // parametre isimleri değiştirebiliriz!
    val id :Int,
    val title : String,
    val description : String,
    val imageUrl : String,
    val releaseDate : String
)
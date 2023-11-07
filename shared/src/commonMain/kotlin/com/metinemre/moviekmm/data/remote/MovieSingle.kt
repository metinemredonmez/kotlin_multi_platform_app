package com.metinemre.moviekmm.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//tek bir film alınıca ihyitacımız olan data model
@Serializable
internal data class MovieSingle (
    val id :Int,
    val title : String,
    val overview : String,
    @SerialName("poster_path")
    val posterImage : String,
    @SerialName("release_date")
    val releaseDate : String
)
package com.metinemre.moviekmm.data.util

import com.metinemre.moviekmm.data.remote.MovieSingle
import com.metinemre.moviekmm.domain.model.Movie

internal fun MovieSingle.toMovie() : Movie {

    return Movie(
        id=id,
        title=title,
        description = overview,
        imageUrl =getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImage : String)= "https://image.tmdb.org/t/p/w500/${posterImage}"
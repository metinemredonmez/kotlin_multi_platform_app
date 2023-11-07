package com.metinemre.moviekmm.domain.repository

import com.metinemre.moviekmm.domain.model.Movie

internal interface MovieRepository {

    suspend fun getMovies(page : Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}
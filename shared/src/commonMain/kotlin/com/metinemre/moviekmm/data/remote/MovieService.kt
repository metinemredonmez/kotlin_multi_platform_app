package com.metinemre.moviekmm.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService :KtorApi() {


    suspend fun getMovies(page: Int = 1) :MoviesList = client.get{
        pathUrl("movie/popular")
        parameter("page",1)

    }.body()

    suspend fun getMovie(movieId: Int) : MovieSingle = client.get{
        pathUrl("movie/${movieId}")
    }.body()

}

//yukarıda MoviesResponse => yerıne MoviesList yazdık / MovieRemote yerine ise MovieSingle yazdık bunu unutma !
package com.metinemre.moviekmm.data.repository

import com.metinemre.moviekmm.data.remote.RemoteDataSource
import com.metinemre.moviekmm.data.util.toMovie
import com.metinemre.moviekmm.domain.model.Movie
import com.metinemre.moviekmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(

    private val remoteDataSource: RemoteDataSource

): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
         return remoteDataSource.getMovies(page= page).results.map {
             it.toMovie()
         }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId=movieId).toMovie()
    }
}
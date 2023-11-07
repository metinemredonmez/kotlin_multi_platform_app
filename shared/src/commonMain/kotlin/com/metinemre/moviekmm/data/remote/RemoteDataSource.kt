package com.metinemre.moviekmm.data.remote

import com.metinemre.moviekmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource (
    private val apiService : MovieService,
    private val dispatcher : Dispatcher
){
    //
   suspend fun getMovies(page:Int) = withContext(dispatcher.io){
       apiService.getMovies(page = page)
    }

   //
    suspend fun getMovie(movieId:Int) = withContext(dispatcher.io){
        apiService.getMovie(movieId = movieId)
    }

}
package com.metinemre.moviekmm.android.home

import android.view.View
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metinemre.moviekmm.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
   val getMoviesUseCase: GetMoviesUseCase
):ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage  = 1



    init {
        loadMovies(forceReload = false)
    }
    fun loadMovies(forceReload :Boolean =false) {

        if (uiState.loading) {
            return
        }
        if (forceReload) {
            currentPage = 1
        }
        if (currentPage == 1) {
            uiState = uiState.copy(refreshing = true)

        }
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            try {
                val resultMovies = getMoviesUseCase(page = currentPage)
                val movies =  if (currentPage == 1) resultMovies
                else  uiState.movies + resultMovies

                currentPage += 1
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = resultMovies.isEmpty(),
                    movies = movies
                )

            }catch (error : Throwable) {
                uiState = uiState.copy(
                    loading = false,
                    refreshing = true,
                    loadFinished = true,
                    errorMessage = "could n ot load ${error.localizedMessage}"
                )
            }

        }
    }

}














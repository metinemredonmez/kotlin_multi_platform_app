package com.metinemre.moviekmm.domain.usecase

import com.metinemre.moviekmm.domain.model.Movie
import com.metinemre.moviekmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMoviesUseCase : KoinComponent {
    private val repository: MovieRepository by inject()

        @Throws(Exception::class)
        suspend operator fun invoke(page: Int): List<Movie> {
            return repository.getMovies(page = page)

        }
    }
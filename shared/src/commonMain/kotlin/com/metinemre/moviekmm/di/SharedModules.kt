package com.metinemre.moviekmm.di

import com.metinemre.moviekmm.data.remote.MovieService
import com.metinemre.moviekmm.data.remote.RemoteDataSource
import com.metinemre.moviekmm.data.repository.MovieRepositoryImpl
import com.metinemre.moviekmm.domain.repository.MovieRepository
import com.metinemre.moviekmm.domain.usecase.GetMovieUseCase
import com.metinemre.moviekmm.domain.usecase.GetMoviesUseCase
import com.metinemre.moviekmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get ()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { provideDispatcher() }
}


private val domainModule = module {
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }

    single<MovieRepository> {MovieRepositoryImpl(get())}
}

private val sharedModules = listOf(dataModule,utilModule,domainModule)
fun getSharedModules() = sharedModules
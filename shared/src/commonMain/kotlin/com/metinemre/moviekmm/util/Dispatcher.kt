package com.metinemre.moviekmm.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io : CoroutineDispatcher

}

internal expect fun provideDispatcher() : Dispatcher


//expect vs actual bul ve ummak ve actual onun uygulanmıs halıdır!
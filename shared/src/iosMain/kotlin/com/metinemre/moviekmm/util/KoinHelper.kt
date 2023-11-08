package com.metinemre.moviekmm.util

import com.metinemre.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin{
        modules(getSharedModules())
    }
}
package com.metinemre.moviekmm.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.*
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// https://api.themoviedb.org/3/movie/951491?api_key=92363bc51b568765ee8c73568b8e01ae
// https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&api_key=92363bc51b568765ee8c73568b8e01ae

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "92363bc51b568765ee8c73568b8e01ae"

abstract class KtorApi{
    // ayrı modul için internal yapalım
    val client = HttpClient{
        install(ContentNegotiation){
            //json builder! ayarları
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }

    }

    fun HttpRequestBuilder.pathUrl(path :String) {
        url {
                takeFrom(BASE_URL)
                path("3",path)
                parameter("api_key", API_KEY)
        }
    }

}
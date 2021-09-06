package com.grupo6cineview.animemovies.features.home.repository

import com.projeto1.movieenjoy.api.ApiService
import com.projeto1.movieenjoy.base.BaseRepository
import com.projeto1.movieenjoy.utils.ResponseApi

class HomeRepository: BaseRepository() {


    suspend fun getNowPlayingMovies() : ResponseApi
    {
         return safeApiCall {
            ApiService.tmdbApi.getNowPlayingMovies()
        }
    }
}
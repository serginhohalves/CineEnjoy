package com.projeto1.movieenjoy.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projeto1.movieenjoy.features.home.usecase.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    //viewmodel chamando a useCase.
   private val homeUseCase = HomeUseCase()


    //Essa funcao veio da View.
    fun getNowPlayingMovies() {

        viewModelScope.launch {
            homeUseCase.getNowPlayingMovies() //indo da viewmodel para view
        //viewmodel nao faz chamada de api.
        }

    }
}
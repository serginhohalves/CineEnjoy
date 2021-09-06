package com.projeto1.movieenjoy.utils

sealed class ResponseApi {
    //Aqui eu explico pro sistema o que eu entendo como sucesso e como erro.
    class Success(var data: Any?) : ResponseApi()
    class Error(var message: Int) : ResponseApi()
}
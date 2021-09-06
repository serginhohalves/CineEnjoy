package com.projeto1.movieenjoy.base

import com.projeto1.movieenjoy.R
import com.projeto1.movieenjoy.utils.ResponseApi
import retrofit2.Response

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>) = safeApiResult(call)

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>) : ResponseApi {

        try {
            //Vai chamar o api em outra thread. por isso o Suspend la em cima.
            val response = call.invoke()
            //(coroutines)x
            // aqui ele para e aguarda o resultado, e só entao ele passa para a linha 19.
            // É o que chamamos de chamada de api assíncrona.
            return if (response.isSuccessful){
                ResponseApi.Success(response.body())
            }
            else {
                val error = ErrorUtils.parseError(response)

                error?.message?.let { message ->
                    ResponseApi.Error(message)
                } ?: run {
                    ResponseApi.Error(R.string.error_default)
                }
            }
        } catch (error : Exception) {
            return ResponseApi.Error(R.string.error_default)
        }
    }
}
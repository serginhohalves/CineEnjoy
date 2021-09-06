package com.grupo6cineview.animemovies.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projeto1.movieenjoy.utils.Command
import com.projeto1.movieenjoy.utils.ResponseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {

    lateinit var command: MutableLiveData<Command>

    suspend fun <T> T.callApi(
        call: suspend ()-> ResponseApi,
        onSuccess: (Any?) -> Unit,
        onError: (() -> Unit?)? = null
    ) {
        command.postValue(Command.Loading(true))

        when(val response = call.invoke()) {
            is ResponseApi.Success -> {
                command.postValue(Command.Loading(false))
                onSuccess(response.data)
            }
            is ResponseApi.Error -> {
                command.postValue(Command.Loading(false))
                onError?.let {
                    withContext(Dispatchers.Main) { onError.invoke() }
                } ?: run {
                    command.postValue(Command.Error(response.message))
                }
            }
        }
    }
}
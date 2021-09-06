package com.projeto1.movieenjoy.model

import com.google.gson.annotations.SerializedName
import com.grupo6cineview.animemovies.model.Dates

data class NowPlaying(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
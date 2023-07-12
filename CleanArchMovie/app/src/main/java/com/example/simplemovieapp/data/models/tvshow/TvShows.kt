package com.example.simplemovieapp.data.models.tvshow


import com.google.gson.annotations.SerializedName

data class TvShows(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tvShows: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
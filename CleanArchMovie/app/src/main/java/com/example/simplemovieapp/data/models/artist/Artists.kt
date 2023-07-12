package com.example.simplemovieapp.data.models.artist


import com.google.gson.annotations.SerializedName

data class Artists(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val artists: List<Artist>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
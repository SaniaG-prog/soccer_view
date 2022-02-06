package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("query")
    val query: QueryAPI,

    @SerializedName("data")
    val data: List<MatchAPI>,
)

package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class QueryAPI(
    @SerializedName("live")
    val live: Boolean,

    @SerializedName("season_id")
    val seasonId: Int,
)

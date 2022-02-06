package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class StatsAPI(
    @SerializedName("home_score")
    val homeScore: Int,

    @SerializedName("away_score")
    val awayScore: Int,

    @SerializedName("ht_score")
    val htScore: String?,

    @SerializedName("ft_score")
    val ftScore: String?,

    @SerializedName("et_score")
    val etScore: String?,

    @SerializedName("ps_score")
    val psScore: String?
)

package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class TeamAPI(
    @SerializedName("team_id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("short_code")
    val shortCode: String,

    @SerializedName("logo")
    val logo: String,

    @SerializedName("country")
    val country: CountryAPI
)

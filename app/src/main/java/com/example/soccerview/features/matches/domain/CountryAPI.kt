package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class CountryAPI(
    @SerializedName("country_id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("country_code")
    val code: String,

    @SerializedName("continent")
    val continent: String
)

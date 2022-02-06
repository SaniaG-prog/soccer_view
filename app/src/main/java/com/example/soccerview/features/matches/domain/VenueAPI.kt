package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class VenueAPI(
    @SerializedName("venue_id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("capacity")
    val capacity: Long,

    @SerializedName("city")
    val city: String,

    @SerializedName("country_id")
    val countryId: Long
)

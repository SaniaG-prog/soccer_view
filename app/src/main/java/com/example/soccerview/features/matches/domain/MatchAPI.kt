package com.example.soccerview.features.matches.domain

import com.google.gson.annotations.SerializedName

data class MatchAPI(
    @SerializedName("match_id")
    val id: Long,

    @SerializedName("status_code")
    val statusCode: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("match_start")
    val matchStart: String,

    @SerializedName("league_id")
    val leagueId: Long,

    @SerializedName("season_id")
    val seasonId: Long,

    @SerializedName("home_team")
    val homeTeam: TeamAPI,

    @SerializedName("away_team")
    val awayTeam: TeamAPI,

    @SerializedName("stats")
    val stats: StatsAPI,

    @SerializedName("venue")
    val venue: VenueAPI,
)

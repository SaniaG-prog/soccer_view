package com.example.soccerview.features.matches.data

data class Match(
    val id: Long,
    val homeTeam: Team,
    val awayTeam: Team,
    val score: String
)

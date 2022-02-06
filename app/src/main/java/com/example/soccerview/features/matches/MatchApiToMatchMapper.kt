package com.example.soccerview.features.matches

import com.example.soccerview.features.matches.data.Match
import com.example.soccerview.features.matches.data.Team
import com.example.soccerview.features.matches.domain.MatchAPI

class MatchApiToMatchMapper : (MatchAPI) -> (Match) {
    override fun invoke(matchAPI: MatchAPI): Match {
        return Match(
            id = matchAPI.id,
            homeTeam = Team(
                name = matchAPI.homeTeam.name,
                logoUrl = matchAPI.homeTeam.logo,
                shortName = matchAPI.homeTeam.shortCode
            ),
            awayTeam = Team(
                name = matchAPI.awayTeam.name,
                logoUrl = matchAPI.awayTeam.logo,
                shortName = matchAPI.awayTeam.shortCode
            ),
            score = "${matchAPI.stats.homeScore} : ${matchAPI.stats.awayScore}",
            venue = "${matchAPI.venue.name}, ${matchAPI.venue.city}"
        )
    }
}
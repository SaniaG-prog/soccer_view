package com.example.soccerview.features.matches.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.soccerview.R
import com.example.soccerview.features.matches.data.Match

class MatchAdapter(private val glide: RequestManager) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    private var dataList: List<Match> = listOf()

    class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val homeTeamName: TextView = view.findViewById(R.id.home_team_name)
        private val homeTeamShortName: TextView = view.findViewById(R.id.home_team_short)
        private val homeTeamLogo: ImageView = view.findViewById(R.id.home_team_logo)
        private val awayTeamName: TextView = view.findViewById(R.id.away_team_name)
        private val awayTeamShortName: TextView = view.findViewById(R.id.away_team_short)
        private val awayTeamLogo: ImageView = view.findViewById(R.id.away_team_logo)
        private val score: TextView = view.findViewById(R.id.score)

        fun bind(glide: RequestManager, match: Match) {
            glide.load(match.homeTeam.logoUrl).into(homeTeamLogo)
            glide.load(match.awayTeam.logoUrl).into(awayTeamLogo)
            homeTeamName.text = match.homeTeam.name
            homeTeamShortName.text = match.homeTeam.shortName.uppercase()
            awayTeamName.text = match.awayTeam.name
            awayTeamShortName.text = match.awayTeam.shortName.uppercase()
            score.text = match.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(glide, dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(newMatches: List<Match>) {
        val matchDiffUtilCallback = MatchDiffUtilCallback(dataList, newMatches)
        val matchDiffResult = DiffUtil.calculateDiff(matchDiffUtilCallback)
        dataList = newMatches
        matchDiffResult.dispatchUpdatesTo(this)
    }
}
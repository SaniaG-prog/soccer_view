package com.example.soccerview.features.matches.view

import androidx.recyclerview.widget.DiffUtil
import com.example.soccerview.features.matches.data.Match

class MatchDiffUtilCallback(private val oldList: List<Match>, private val newList: List<Match>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].homeTeam.name == newList[newItemPosition].homeTeam.name &&
                oldList[oldItemPosition].homeTeam.shortName == newList[newItemPosition].homeTeam.shortName &&
                oldList[oldItemPosition].homeTeam.logoUrl == newList[newItemPosition].homeTeam.logoUrl &&
                oldList[oldItemPosition].awayTeam.name == newList[newItemPosition].awayTeam.name &&
                oldList[oldItemPosition].awayTeam.shortName == newList[newItemPosition].awayTeam.shortName &&
                oldList[oldItemPosition].awayTeam.logoUrl == newList[newItemPosition].awayTeam.logoUrl &&
                oldList[oldItemPosition].score == newList[newItemPosition].score
    }
}
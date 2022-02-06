package com.example.soccerview.features.matches.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soccerview.features.matches.MatchApiToMatchMapper
import com.example.soccerview.features.matches.data.Match
import com.example.soccerview.features.matches.domain.ApiService
import io.reactivex.schedulers.Schedulers

class MatchesViewModel : ViewModel() {

    private var _matchesState: MutableLiveData<List<Match>> = MutableLiveData()
    val matchesState: LiveData<List<Match>>
        get() = _matchesState
    private val apiService = ApiService.create()

    init {
        loadMatches()
    }

    private fun loadMatches() {
        apiService.getMatches().subscribeOn(Schedulers.io())
            .map { response -> response.data.map(MatchApiToMatchMapper()) }
            .doAfterSuccess { data -> _matchesState.postValue(data) }.subscribe()
    }
}
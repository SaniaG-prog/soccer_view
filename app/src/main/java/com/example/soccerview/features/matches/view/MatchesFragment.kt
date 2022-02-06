package com.example.soccerview.features.matches.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerview.R


class MatchesFragment : Fragment() {

    private lateinit var viewModel: MatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MatchesViewModel::class.java)
        val matchRecyclerView: RecyclerView = view.findViewById(R.id.match_recycler_view)
        val matchAdapter = MatchAdapter(Glide.with(this))

        matchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        matchRecyclerView.adapter = matchAdapter

        viewModel.matchesState.observe(requireActivity()) {
            matchAdapter.setData(it)
        }
    }

    companion object {
        fun newInstance() = MatchesFragment()
    }
}
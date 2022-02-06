package com.example.soccerview.features.matches.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerview.R
import com.example.soccerview.features.web_view.WebViewFragment


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

        val matchRecyclerView: RecyclerView = view.findViewById(R.id.match_recycler_view)
        val buttonToWebView: Button = view.findViewById(R.id.button_go_to_webview)
        val matchAdapter = MatchAdapter(Glide.with(this))

        viewModel = ViewModelProvider(requireActivity()).get(MatchesViewModel::class.java)

        matchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        matchRecyclerView.adapter = matchAdapter

        viewModel.matchesState.observe(requireActivity()) {
            matchAdapter.setData(it)
        }

        buttonToWebView.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.activity_fragment_container, WebViewFragment.newInstance())
                .addToBackStack(null).commit()
        }
    }

    companion object {
        fun newInstance() = MatchesFragment()
    }
}
package com.example.soccerview.features.splash_screen

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.soccerview.R
import com.example.soccerview.features.matches.view.MatchesFragment
import com.example.soccerview.features.matches.view.MatchesViewModel

class SplashScreenFragment : Fragment() {

    private lateinit var viewModel: MatchesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MatchesViewModel::class.java)
        viewModel.loadMatches()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animationView: LottieAnimationView = view.findViewById(R.id.splash_screen_animation)
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.activity_fragment_container, MatchesFragment.newInstance())
                    .commit()
            }

            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationStart(animation: Animator?) {}
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = SplashScreenFragment()
    }
}
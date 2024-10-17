package com.nelalexxx.unscramlewordgame.ui.fragments.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModel
import com.nelalexxx.unscramlewordgame.databinding.StatsFragmentLayoutBinding
import com.nelalexxx.unscramlewordgame.ui.fragments.BindingFragment


class StatsFragment : BindingFragment<StatsFragmentLayoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = StatsFragmentLayoutBinding::inflate
    private val viewModel: GameViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.statsTextView.text = "Correct answers: ${viewModel.getCorrectAnswers().toString()}"

        binding.newGameButton.setOnClickListener {
            viewModel.init()
            findNavController().navigate(
                R.id.loadingFragment,
                null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.statsFragment, true)
                    .build()
            )
        }
    }
}
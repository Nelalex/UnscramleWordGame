package com.nelalexxx.unscramlewordgame.ui.fragments.game

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameUiState
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModel
import com.nelalexxx.unscramlewordgame.databinding.GameFragmentLayoutBinding
import com.nelalexxx.unscramlewordgame.ui.fragments.BindingFragment

class GameFragment : BindingFragment<GameFragmentLayoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = GameFragmentLayoutBinding::inflate
    private val viewModel: GameViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.init()
        update()
        binding.checkButton.setOnClickListener {
            viewModel.uiState = viewModel.check(binding.inputFieldEditText.text.toString())
            update()
        }

        binding.getNextWordButton.setOnClickListener {
            viewModel.uiState = viewModel.goNextWord()
            if (viewModel.uiState == GameUiState.Empty) {
                findNavController().navigate(
                    R.id.statsFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.gameFragment, true)
                        .build()
                )
            }
            update()
        }


        binding.inputFieldEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.uiState =
                    viewModel.editInputField(binding.inputFieldEditText.text.toString())
                update()
            }
        })
    }

    fun update() {
        viewModel.uiState.update(
            binding.wordTextView,
            binding.inputFieldEditText,
            binding.inputFieldLayout,
            binding.checkButton,
            binding.getNextWordButton
        )
    }
}



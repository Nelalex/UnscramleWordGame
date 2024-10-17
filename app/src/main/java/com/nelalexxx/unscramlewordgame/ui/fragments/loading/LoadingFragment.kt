package com.nelalexxx.unscramlewordgame.ui.fragments.loading

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModel
import com.nelalexxx.unscramlewordgame.databinding.LoadingFragmentLayoutBinding
import com.nelalexxx.unscramlewordgame.retrofit.RetrofitInstance
import com.nelalexxx.unscramlewordgame.ui.fragments.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoadingFragment : BindingFragment<LoadingFragmentLayoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = LoadingFragmentLayoutBinding::inflate
    private val viewModel: GameViewModel by activityViewModels()
    private lateinit var uiState: LoadingUiState

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tryGetData()
        binding.retryConnectBtn.setOnClickListener {
            uiState = LoadingUiState.AttemptToConnect
            updateUI()
            tryGetData()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("uiState", uiState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        uiState = savedInstanceState?.getSerializable("uiState") as? LoadingUiState
            ?: LoadingUiState.Empty
        updateUI()
    }

    private fun tryGetData() {
        lifecycleScope.launch {
            var wordsList: List<String>? = null
            while (wordsList == null) {
                try {
                    val response = RetrofitInstance().api.getWordsList()
                    if (response.isSuccessful) {
                        wordsList = response.body()
                        viewModel.setWordListFromApi(wordsList!!)
                        findNavController().navigate(
                            R.id.gameFragment,
                            null,
                            NavOptions.Builder()
                                .setPopUpTo(R.id.loadingFragment, true)
                                .build()
                        )
                    } else {
                        Log.d("LoadingFragment", "API error: ${response.code()}")
                        showError()
                    }
                } catch (e: Exception) {
                    Log.d("LoadingFragment", "Network error: ${e.message}")
                    showError()
                }
            }
        }
    }

    private suspend fun showError() {
        delay(2000)
        uiState = LoadingUiState.ConnectionError
        updateUI()
    }

    private fun updateUI() {
        uiState.update(
            binding.warningTV,
            binding.loadProgressBar,
            binding.retryConnectBtn
        )
    }
}


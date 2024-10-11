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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingFragment : BindingFragment<LoadingFragmentLayoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = LoadingFragmentLayoutBinding::inflate
    private val viewModel: GameViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tryGetData()
        binding.retryConnectBtn.setOnClickListener {
            binding.warningTV.visibility = View.INVISIBLE
            binding.loadProgressBar.visibility = View.VISIBLE
            binding.retryConnectBtn.visibility = View.INVISIBLE
            tryGetData()
        }

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
                        // Handle API error, e.g., log the error, show a snackbar
                        Log.e("LoadingFragment", "API error: ${response.code()}")
                        showError()
                    }
                } catch (e: Exception) {
                    // Handle network error, e.g., show a message, retry after delay
                    Log.e("LoadingFragment", "Network error: ${e.message}")
                    showError()
                }
            }
        }
    }

    private suspend fun showError() {
        delay(2000)
        binding.warningTV.visibility = View.VISIBLE
        binding.loadProgressBar.visibility = View.INVISIBLE
        binding.retryConnectBtn.visibility = View.VISIBLE
    }


}


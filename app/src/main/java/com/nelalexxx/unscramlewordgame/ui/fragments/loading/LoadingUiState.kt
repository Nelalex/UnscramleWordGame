package com.nelalexxx.unscramlewordgame.ui.fragments.loading

import android.view.View
import com.nelalexxx.unscramlewordgame.ui.customViews.button.UpdateButtonVisibility
import com.nelalexxx.unscramlewordgame.ui.customViews.progressBar.UpdateProgressBarVisibility
import com.nelalexxx.unscramlewordgame.ui.customViews.word.UpdateTextViewVisibility
import java.io.Serializable

interface LoadingUiState : Serializable {

    fun update(
        warningTextView: UpdateTextViewVisibility,
        loadProgressBar: UpdateProgressBarVisibility,
        retryConnectBtn: UpdateButtonVisibility,
    ) = Unit

    object ConnectionError : LoadingUiState {
        override fun update(
            warningTextView: UpdateTextViewVisibility,
            loadProgressBar: UpdateProgressBarVisibility,
            retryConnectBtn: UpdateButtonVisibility,
        ) {
            warningTextView.update(View.VISIBLE)
            loadProgressBar.update(View.INVISIBLE)
            retryConnectBtn.updateVisibility(View.VISIBLE)
        }
    }

    object AttemptToConnect : LoadingUiState {
        override fun update(
            warningTextView: UpdateTextViewVisibility,
            loadProgressBar: UpdateProgressBarVisibility,
            retryConnectBtn: UpdateButtonVisibility,
        ) {
            warningTextView.update(View.INVISIBLE)
            loadProgressBar.update(View.VISIBLE)
            retryConnectBtn.updateVisibility(View.INVISIBLE)
        }
    }

    object Empty : LoadingUiState
}
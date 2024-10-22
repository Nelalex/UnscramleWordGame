package com.nelalexxx.unscramlewordgame.ui.fragments.loading

import android.view.View
import com.nelalexxx.unscramlewordgame.ui.customViews.button.UpdateMyButton
import com.nelalexxx.unscramlewordgame.ui.customViews.progressBar.UpdateMyProgressBar
import com.nelalexxx.unscramlewordgame.ui.customViews.word.UpdateMyTextView
import java.io.Serializable

interface LoadingUiState : Serializable {

    fun update(
        warningTextView: UpdateMyTextView,
        loadProgressBar: UpdateMyProgressBar,
        retryConnectBtn: UpdateMyButton
    ) = Unit

    object ConnectionError : LoadingUiState {
        override fun update(
            warningTextView: UpdateMyTextView,
            loadProgressBar: UpdateMyProgressBar,
            retryConnectBtn: UpdateMyButton
        ) {
            warningTextView.updateVisibility(View.VISIBLE)
            loadProgressBar.updateVisibility(View.INVISIBLE)
            retryConnectBtn.updateVisibility(View.VISIBLE)
        }
    }

    object AttemptToConnect : LoadingUiState {
        override fun update(
            warningTextView: UpdateMyTextView,
            loadProgressBar: UpdateMyProgressBar,
            retryConnectBtn: UpdateMyButton
        ) {
            warningTextView.updateVisibility(View.INVISIBLE)
            loadProgressBar.updateVisibility(View.VISIBLE)
            retryConnectBtn.updateVisibility(View.INVISIBLE)
        }
    }

    object Empty : LoadingUiState

    object Success : LoadingUiState
}
package com.nelalexxx.unscramlewordgame.ui.fragments.game

import android.view.View
import android.view.animation.AnimationUtils
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.ui.customViews.button.UpdateMyButton
import com.nelalexxx.unscramlewordgame.ui.customViews.editText.CustomEditText
import com.nelalexxx.unscramlewordgame.ui.customViews.editText.UpdateMyTextInputLayout
import com.nelalexxx.unscramlewordgame.ui.customViews.word.UpdateMyTextView

import java.io.Serializable

interface GameUiState : Serializable {

    fun update(
        wordTextView: UpdateMyTextView,
        editText: CustomEditText,
        inputFieldLayout: UpdateMyTextInputLayout,
        checkButton: UpdateMyButton,
        nextButton: UpdateMyButton
    ) = Unit

    object Empty : GameUiState

    data class ScrambleWordReceived(
        val text: String
    ) : GameUiState {
        override fun update(
            wordTextView: UpdateMyTextView,
            editText: CustomEditText,
            inputFieldLayout: UpdateMyTextInputLayout,
            checkButton: UpdateMyButton,
            nextButton: UpdateMyButton
        ) {
            wordTextView.updateText(text = text)
            editText.clear()
            editText.updateEnabled(enabled = true)
            inputFieldLayout.updateText(text = R.string.hint)
            checkButton.updateVisibility(visibility = View.INVISIBLE)
            nextButton.updateColor(text = R.string.skip)
        }
    }

    data class TextEdited(private val flag: Int = 1) : GameUiState {
        override fun update(
            wordTextView: UpdateMyTextView,
            editText: CustomEditText,
            inputFieldLayout: UpdateMyTextInputLayout,
            checkButton: UpdateMyButton,
            nextButton: UpdateMyButton
        ) {
            if (flag == -1) {
                checkButton.updateVisibility(visibility = View.INVISIBLE)
            } else
                checkButton.updateVisibility(visibility = View.VISIBLE)
            nextButton.updateColor(text = R.string.skip)
            editText.updateEnabled(enabled = true)
            inputFieldLayout.updateText(text = R.string.hint)
        }
    }

    object CorrectWord : GameUiState {
        override fun update(
            wordTextView: UpdateMyTextView,
            editText: CustomEditText,
            inputFieldLayout: UpdateMyTextInputLayout,
            checkButton: UpdateMyButton,
            nextButton: UpdateMyButton
        ) {
            checkButton.updateVisibility(visibility = View.INVISIBLE)
            nextButton.updateColor(text = R.string.next)
            editText.updateEnabled(enabled = false)
            inputFieldLayout.updateText(text = R.string.correct)
        }
    }

    object InCorrectWord :
        GameUiState {
        override fun update(
            wordTextView: UpdateMyTextView,
            editText: CustomEditText,
            inputFieldLayout: UpdateMyTextInputLayout,
            checkButton: UpdateMyButton,
            nextButton: UpdateMyButton
        ) {
            checkButton.updateVisibility(visibility = View.VISIBLE)
            editText.updateEnabled(enabled = true)
            inputFieldLayout.updateText(text = R.string.incorrect)

            val shakeAnimation = AnimationUtils.loadAnimation(editText.context, R.anim.shake)
            editText.startAnimation(shakeAnimation)
        }
    }
}

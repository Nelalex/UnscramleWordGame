package com.nelalexxx.unscramlewordgame.data.viewmodels

import android.view.animation.AnimationUtils
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.ui.customViews.button.UpdateButton
import com.nelalexxx.unscramlewordgame.ui.customViews.editText.CustomEditText
import com.nelalexxx.unscramlewordgame.ui.customViews.editText.UpdateLayout
import com.nelalexxx.unscramlewordgame.ui.customViews.word.UpdateText
import java.io.Serializable

interface GameUiState : Serializable {

    fun update(
        wordTextView: UpdateText,
        editText: CustomEditText,
        inputFieldLayout: UpdateLayout,
        checkButton: UpdateButton,
        nextButton: UpdateButton,
    )

    object Empty : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) = Unit
    }

    data class ScrambleWordReceived(
        val text: String
    ) : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            wordTextView.update(text)
            editText.update(enabled = true, "")
            inputFieldLayout.update(R.color.white, R.string.hint)
            checkButton.update(visibility = false)
            nextButton.update(text = R.string.skip)
        }
    }

    data class TextEdited(private val flag: Int = 1) : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            if (flag == -1) {
                checkButton.update(visibility = false)
            } else
                checkButton.update(visibility = true)
            nextButton.update(text = R.string.skip)
            editText.update(enabled = true)
            inputFieldLayout.update(R.color.white, R.string.hint)
        }
    }

    object CorrectWord : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            checkButton.update(visibility = false)
            nextButton.update(R.string.next)
            editText.update(enabled = false)
            inputFieldLayout.update(R.color.Correct, R.string.correct)
        }
    }

    object InCorrectWord :
        GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            checkButton.update(visibility = true)
            editText.update(enabled = true)
            inputFieldLayout.update(R.color.Incorrect, R.string.incorrect)

            val shakeAnimation = AnimationUtils.loadAnimation(editText.context, R.anim.shake)
            editText.startAnimation(shakeAnimation)
        }
    }
}

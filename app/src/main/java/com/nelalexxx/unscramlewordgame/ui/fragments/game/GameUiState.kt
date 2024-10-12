package com.nelalexxx.unscramlewordgame.ui.fragments.game

import android.view.View
import android.view.animation.AnimationUtils
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.ui.customViews.button.CustomButton
import com.nelalexxx.unscramlewordgame.ui.customViews.editText.CustomEditText
import com.nelalexxx.unscramlewordgame.ui.customViews.editText.CustomTextInputLayout
import com.nelalexxx.unscramlewordgame.ui.customViews.word.UpdateTextViewText
import java.io.Serializable

interface GameUiState : Serializable {

    fun update(
        wordTextView: UpdateTextViewText,
        editText: CustomEditText,
        inputFieldLayout: CustomTextInputLayout,
        checkButton: CustomButton,
        nextButton: CustomButton
    ) = Unit

    object Empty : GameUiState

    data class ScrambleWordReceived(
        val text: String
    ) : GameUiState {
        override fun update(
            wordTextView: UpdateTextViewText,
            editText: CustomEditText,
            inputFieldLayout: CustomTextInputLayout,
            checkButton: CustomButton,
            nextButton: CustomButton
        ) {
            wordTextView.update(text = text)
            editText.clear()
            editText.update(enabled = true)
            inputFieldLayout.updateHintText(hintText = R.string.hint)
            checkButton.updateVisibility(visibility = View.INVISIBLE)
            nextButton.update(text = R.string.skip)
        }
    }

    data class TextEdited(private val flag: Int = 1) : GameUiState {
        override fun update(
            wordTextView: UpdateTextViewText,
            editText: CustomEditText,
            inputFieldLayout: CustomTextInputLayout,
            checkButton: CustomButton,
            nextButton: CustomButton
        ) {
            if (flag == -1) {
                checkButton.updateVisibility(visibility = View.INVISIBLE)
            } else
                checkButton.updateVisibility(visibility = View.VISIBLE)
            nextButton.update(text = R.string.skip)
            editText.update(enabled = true)
            inputFieldLayout.updateHintText(hintText = R.string.hint)
        }
    }

    object CorrectWord : GameUiState {
        override fun update(
            wordTextView: UpdateTextViewText,
            editText: CustomEditText,
            inputFieldLayout: CustomTextInputLayout,
            checkButton: CustomButton,
            nextButton: CustomButton
        ) {
            checkButton.updateVisibility(visibility = View.INVISIBLE)
            nextButton.update(text = R.string.next)
            editText.update(enabled = false)
            inputFieldLayout.updateHintText(hintText = R.string.correct)
        }
    }

    object InCorrectWord :
        GameUiState {
        override fun update(
            wordTextView: UpdateTextViewText,
            editText: CustomEditText,
            inputFieldLayout: CustomTextInputLayout,
            checkButton: CustomButton,
            nextButton: CustomButton
        ) {
            checkButton.updateVisibility(visibility = View.VISIBLE)
            editText.update(enabled = true)
            inputFieldLayout.updateHintText(hintText = R.string.incorrect)

            val shakeAnimation = AnimationUtils.loadAnimation(editText.context, R.anim.shake)
            editText.startAnimation(shakeAnimation)
        }
    }
}

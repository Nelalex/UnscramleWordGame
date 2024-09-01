package com.nelalexxx.unscramlewordgame

import com.nelalexxx.unscramlewordgame.views.button.UpdateVisibility
import com.nelalexxx.unscramlewordgame.views.button.VisibilityState
import com.nelalexxx.unscramlewordgame.views.word.UpdateText
import java.io.Serializable

interface GameUiState : Serializable {

    fun update(
        wordTextView: UpdateText,
        inputFieldEditText: UpdateText,
        checkButton: UpdateVisibility,
        nextButton: UpdateVisibility,
    )


    object Empty : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            inputFieldEditText: UpdateText,
            checkButton: UpdateVisibility,
            nextButton: UpdateVisibility
        ) = Unit
    }


    data class ScrambleWordReceived(
        val text: String
    ) : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            inputFieldEditText: UpdateText,
            checkButton: UpdateVisibility,
            nextButton: UpdateVisibility
        ) {
            wordTextView.update(text)
            inputFieldEditText.update("")
            checkButton.update(VisibilityState.Gone)
            nextButton.update(VisibilityState.Visible)
        }

    }

    class CorrectWord() : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            inputFieldEditText: UpdateText,
            checkButton: UpdateVisibility,
            nextButton: UpdateVisibility
        ) {
            checkButton.update(VisibilityState.Gone)
        }

    }

    class InCorrectWord() :
        GameUiState {
        override fun update(
            wordTextView: UpdateText,
            inputFieldEditText: UpdateText,
            checkButton: UpdateVisibility,
            nextButton: UpdateVisibility
        ) {
            checkButton.update(VisibilityState.Visible)
        }

    }

    class TextEdited(private val flag: Int = 1) : GameUiState {

        override fun update(
            wordTextView: UpdateText,
            inputFieldEditText: UpdateText,
            checkButton: UpdateVisibility,
            nextButton: UpdateVisibility
        ) {
            if (flag == -1) {
                checkButton.update(VisibilityState.Gone)
            } else
                checkButton.update(VisibilityState.Visible)
            nextButton.update(VisibilityState.Visible)
        }


    }


}

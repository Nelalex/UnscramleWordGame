package com.nelalexxx.unscramlewordgame.ui.customViews.button

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.google.android.material.button.MaterialButton
import com.nelalexxx.unscramlewordgame.R


class CustomButton : MaterialButton, UpdateButtonText, UpdateButtonVisibility {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(text: Int) {
        this.text = getString(this.context, text)
        if (text == R.string.next)
            this.setBackgroundColor(ContextCompat.getColor(this.context, R.color.Correct))
        else
            this.setBackgroundColor(ContextCompat.getColor(this.context, R.color.Incorrect))

    }

    override fun updateVisibility(visibility: Int) {
        this.visibility = visibility
    }
}

interface UpdateButtonText {
    fun update(text: Int)
}

interface UpdateButtonVisibility {
    fun updateVisibility(visibility: Int)
}

package com.nelalexxx.unscramlewordgame.ui.customViews.button

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.google.android.material.button.MaterialButton
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.ui.customViews.UpdateViews


class CustomButton : MaterialButton, UpdateMyButton {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun updateColor(text: Int) {
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

interface UpdateMyButton : UpdateViews.Color, UpdateViews.Visibility

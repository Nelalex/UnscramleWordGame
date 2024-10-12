package com.nelalexxx.unscramlewordgame.ui.customViews.editText

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat.getString
import com.google.android.material.textfield.TextInputLayout

class CustomTextInputLayout : TextInputLayout, UpdateTextInputHintText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun updateHintText(hintText: Int) {
        this.hint = getString(this.context, hintText)
    }
}

interface UpdateTextInputHintText {
    fun updateHintText(hintText: Int)
}

package com.nelalexxx.unscramlewordgame.ui.customViews.editText

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat.getString
import com.google.android.material.textfield.TextInputLayout
import com.nelalexxx.unscramlewordgame.ui.customViews.UpdateViews

class CustomTextInputLayout : TextInputLayout, UpdateMyTextInputLayout {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun updateText(text: Int) {
        this.hint = getString(this.context, text)
    }
}

interface UpdateMyTextInputLayout : UpdateViews.TextFromResources

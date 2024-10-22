package com.nelalexxx.unscramlewordgame.ui.customViews.editText

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.nelalexxx.unscramlewordgame.ui.customViews.UpdateViews

class CustomEditText : TextInputEditText, UpdateMyEditText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun clear() {
        this.setText("")
    }

    override fun updateEnabled(enabled: Boolean) {
        this.isEnabled = enabled
    }
}

interface UpdateMyEditText : UpdateViews.ClearText, UpdateViews.TextEnabled



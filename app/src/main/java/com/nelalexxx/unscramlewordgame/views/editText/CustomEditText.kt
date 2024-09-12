package com.nelalexxx.unscramlewordgame.views.editText

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText

class CustomEditText : TextInputEditText, UpdateEditText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(enabled: Boolean, text: String) {
        this.isEnabled = enabled
        this.setText(text)

    }

    override fun update(enabled: Boolean) {
        this.isEnabled = enabled
    }

}

interface UpdateEditText {

    fun update(enabled: Boolean, text: String)
    fun update(enabled: Boolean)

}


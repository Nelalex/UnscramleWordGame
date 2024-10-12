package com.nelalexxx.unscramlewordgame.ui.customViews.editText

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText

class CustomEditText : TextInputEditText, UpdateEditTextAvailability, ClearEditText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(enabled: Boolean) {
        this.isEnabled = enabled
    }

    override fun clear() {
        this.setText("")
    }

}

interface UpdateEditTextAvailability {
    fun update(enabled: Boolean)
}

interface ClearEditText {
    fun clear()
}



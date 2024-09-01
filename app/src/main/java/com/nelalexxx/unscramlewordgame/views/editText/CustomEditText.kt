package com.nelalexxx.unscramlewordgame.views.editText

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.nelalexxx.unscramlewordgame.views.word.UpdateText

class CustomEditText : TextInputEditText, UpdateText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(text: String) {
        this.setText(text)
    }

}


package com.nelalexxx.unscramlewordgame.views.word

import android.content.Context
import android.util.AttributeSet

class WordTextView : androidx.appcompat.widget.AppCompatTextView, UpdateText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(text: String) {
        this.text = text
    }

    override fun getFreezesText() = true

}

interface UpdateText {

    fun update(text: String)
}
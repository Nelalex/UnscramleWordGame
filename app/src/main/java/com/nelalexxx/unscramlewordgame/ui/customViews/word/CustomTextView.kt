package com.nelalexxx.unscramlewordgame.ui.customViews.word

import android.content.Context
import android.util.AttributeSet

class WordTextView : androidx.appcompat.widget.AppCompatTextView, UpdateTextViewText,
    UpdateTextViewVisibility {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(text: String) {
        this.text = text
    }

    override fun update(visibility: Int) {
        this.visibility = visibility
    }
}

interface UpdateTextViewText {
    fun update(text: String)
}

interface UpdateTextViewVisibility {
    fun update(visibility: Int)
}
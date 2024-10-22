package com.nelalexxx.unscramlewordgame.ui.customViews.word

import android.content.Context
import android.util.AttributeSet
import com.nelalexxx.unscramlewordgame.ui.customViews.UpdateViews

class WordTextView : androidx.appcompat.widget.AppCompatTextView, UpdateMyTextView {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun updateText(text: String) {
        this.text = text
    }

    override fun updateVisibility(visibility: Int) {
        this.visibility = visibility
    }
}

interface UpdateMyTextView : UpdateViews.Text, UpdateViews.Visibility
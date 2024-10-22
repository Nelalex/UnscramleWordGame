package com.nelalexxx.unscramlewordgame.ui.customViews.progressBar

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar
import com.nelalexxx.unscramlewordgame.ui.customViews.UpdateViews

class CustomProgressBar : ProgressBar, UpdateMyProgressBar {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun updateVisibility(visibility: Int) {
        this.visibility = visibility
    }
}

interface UpdateMyProgressBar : UpdateViews.Visibility
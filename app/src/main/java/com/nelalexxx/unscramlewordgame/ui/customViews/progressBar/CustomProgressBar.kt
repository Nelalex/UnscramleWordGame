package com.nelalexxx.unscramlewordgame.ui.customViews.progressBar

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar

class CustomProgressBar : ProgressBar, UpdateProgressBarVisibility {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(visibility: Int) {
        this.visibility = visibility
    }
}

interface UpdateProgressBarVisibility {
    fun update(visibility: Int)
}
package com.nelalexxx.unscramlewordgame.views.button

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.nelalexxx.unscramlewordgame.R


class CustomButton : AppCompatButton, UpdateButton {

//    private var savedText: Int = 0
//    private var savedVisibility: Int = View.VISIBLE

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)


    override fun update(text: Int) {
        this.text = getString(this.context, text)
        if (text == R.string.next)
            this.setBackgroundColor(ContextCompat.getColor(this.context, R.color.Correct))
        else
            this.setBackgroundColor(ContextCompat.getColor(this.context, R.color.Incorrect))

    }

    override fun update(visibility: Boolean) {
        this.visibility = if (visibility)
            View.VISIBLE
        else
            View.INVISIBLE
    }

}

interface UpdateButton {
    fun update(text: Int)
    fun update(visibility: Boolean)

}

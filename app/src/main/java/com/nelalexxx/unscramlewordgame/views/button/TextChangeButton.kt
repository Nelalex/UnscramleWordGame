package com.nelalexxx.unscramlewordgame.views.button

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.nelalexxx.unscramlewordgame.views.word.UpdateText


class TextChangeButton : AppCompatButton, UpdateText {

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)


    override fun update(text: String) {
        this.text = text
    }


}

interface UpdateText {
    fun update(text: String)
}
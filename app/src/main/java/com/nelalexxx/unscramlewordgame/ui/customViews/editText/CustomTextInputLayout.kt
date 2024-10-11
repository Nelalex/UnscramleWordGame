package com.nelalexxx.unscramlewordgame.ui.customViews.editText

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.google.android.material.textfield.TextInputLayout

class CustomTextInputLayout : TextInputLayout, UpdateLayout {

    private var savedBackgroundColor: Int = 0

    constructor(context: Context)
            : super(context)

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun update(color: Int, hintText: Int) {
        this.boxBackgroundColor = (ContextCompat.getColor(this.context, color))
        this.hint = getString(this.context, hintText)
    }

    override fun onSaveInstanceState(): Parcelable {
        val superState = super.onSaveInstanceState()
        val bundle = Bundle()
        bundle.putParcelable("superState", superState)
        bundle.putInt("boxBackgroundColor", boxBackgroundColor)
        return bundle
    }


    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            savedBackgroundColor = state.getInt("boxBackgroundColor")
            boxBackgroundColor = savedBackgroundColor
            super.onRestoreInstanceState(state.getParcelable("superState"))
        } else {
            super.onRestoreInstanceState(state)
        }
    }


}

interface UpdateLayout {
    fun update(color: Int, hintText: Int)
}

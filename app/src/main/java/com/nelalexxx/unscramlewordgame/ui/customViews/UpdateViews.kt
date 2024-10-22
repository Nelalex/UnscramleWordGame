package com.nelalexxx.unscramlewordgame.ui.customViews

abstract class UpdateViews {

    interface TextEnabled {
        fun updateEnabled(enabled: Boolean)
    }

    interface Text {
        fun updateText(text: String)
    }

    interface Visibility {
        fun updateVisibility(visibility: Int)
    }

    interface TextFromResources {
        fun updateText(text: Int)
    }

    interface ClearText {
        fun clear()
    }

    interface Color {
        fun updateColor(text: Int)
    }

}
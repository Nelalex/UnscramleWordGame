package com.nelalexxx.unscramlewordgame.ui.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class CustomActivity : AppCompatActivity() {
    //We dont have back navigation so we can override button
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Confirm Exit")
            .setMessage("Are you sure want to exit the app?")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No") { _, _ ->
            }
            .show()
    }
}
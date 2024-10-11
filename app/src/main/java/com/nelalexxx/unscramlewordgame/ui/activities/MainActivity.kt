package com.nelalexxx.unscramlewordgame.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModel
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModelFactory
import com.nelalexxx.unscramlewordgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //ViewModel
    private lateinit var viewModel: GameViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Fragments
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        //Navigation
        navController = navHostFragment.navController

        val viewModelFactory = GameViewModelFactory(GameRepository.Base)
        viewModel = ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]


    }

    //We dont have back navigation so we can override button
    override fun onBackPressed() {
        if (true) {
            // Show AlertDialog
            AlertDialog.Builder(this)
                .setTitle("Confirm Exit")
                .setMessage("Are you sure want to exit the app?")
                .setPositiveButton("Yes") { _, _ -> finish() }
                .setNegativeButton("No", null)
                .show()
        } else {
            super.onBackPressed() // Default back navigation
        }
    }

}
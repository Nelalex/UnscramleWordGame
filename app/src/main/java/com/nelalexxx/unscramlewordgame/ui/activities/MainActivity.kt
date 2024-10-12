package com.nelalexxx.unscramlewordgame.ui.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.nelalexxx.unscramlewordgame.R
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepositoryImpl
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModel
import com.nelalexxx.unscramlewordgame.data.viewmodels.GameViewModelFactory
import com.nelalexxx.unscramlewordgame.databinding.ActivityMainBinding

class MainActivity : CustomActivity() {
    //ViewModel
    private lateinit var viewModel: GameViewModel
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Fragments
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        //Navigation
        navController = navHostFragment.navController
        //ViewModel
        val repository = GameRepositoryImpl()
        val viewModelFactory = GameViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]
    }
}
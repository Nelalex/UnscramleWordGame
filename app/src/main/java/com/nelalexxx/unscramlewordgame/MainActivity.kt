package com.nelalexxx.unscramlewordgame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nelalexxx.unscramlewordgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel: GameViewModel = GameViewModel()

        binding.nextButton.setOnClickListener {
            val uiState: GameUiState =
                viewModel.check(text = binding.inputFieldEditText.text.toString())
            uiState.update(binding = binding)
        }

        binding.nextButton.setOnClickListener {
            val uiState: GameUiState = viewModel.goNextWord()
            uiState.update(binding = binding)
        }


        val uiState: GameUiState = viewModel.init()
        uiState.update(binding = binding)
    }


}

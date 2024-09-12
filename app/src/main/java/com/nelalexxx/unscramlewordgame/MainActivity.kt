package com.nelalexxx.unscramlewordgame

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nelalexxx.unscramlewordgame.databinding.ActivityMainBinding


private lateinit var uiState: GameUiState
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val viewModel: GameViewModel = (application as ScrumbleWordApp).viewModel




        uiState = viewModel.init(savedInstanceState == null)
        update()


        binding.checkButton.setOnClickListener {
            uiState = viewModel.check(binding.inputFieldEditText.text.toString())
            update()
        }

        binding.getNextWordButton.setOnClickListener {
            uiState = viewModel.goNextWord()
            update()
        }




        binding.inputFieldEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                uiState = viewModel.editInputField(binding.inputFieldEditText.text.toString())
                update()
            }
        })


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("uiState", uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable("uiState") as GameUiState
        update()
    }


    fun update() {
        uiState.update(
            binding.wordTextView,
            binding.inputFieldEditText,
            binding.inputFieldLayout,
            binding.checkButton,
            binding.getNextWordButton
        )
    }
}

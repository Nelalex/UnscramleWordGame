package com.nelalexxx.unscramlewordgame

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.nelalexxx.unscramlewordgame.databinding.ActivityMainBinding


private lateinit var uiState: GameUiState
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: GameViewModel = (application as ScrumbleWordApp).viewModel

        uiState = viewModel.init(savedInstanceState == null)
        update()


        binding.checkButton.setOnClickListener {
            uiState = viewModel.check(binding.inputFieldEditText.text.toString())
            update()
        }

        binding.getNextWordButton.setOnClickListener {
            uiState = viewModel.goNextWord()
            if (uiState == GameUiState.Empty) {
                val intent = Intent(this, StatsActivity::class.java)
                intent.putExtra("result", viewModel.getCorrectAnswers())
                startActivity(intent)
                finish()
            }
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

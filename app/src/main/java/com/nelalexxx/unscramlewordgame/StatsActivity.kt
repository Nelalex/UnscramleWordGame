package com.nelalexxx.unscramlewordgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nelalexxx.unscramlewordgame.databinding.StatsLayoutBinding


private lateinit var binding: StatsLayoutBinding

class StatsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StatsLayoutBinding.inflate(layoutInflater)

        val result = intent.getIntExtra("result", 0)
        binding.statsTextView.text = "Not skipped words: $result"
        setContentView(binding.root)
//        Log.d("Mytest", "created")


        binding.newGameButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("Mytest", "destroyed")
//    }


}
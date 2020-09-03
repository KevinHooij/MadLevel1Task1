package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding


class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private fun initViews(){
        updateUI()
    }


    private fun updateUI(){
        binding.lastThrowTv.text = getString(R.string.last_throw_text, lastThrow)
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

}
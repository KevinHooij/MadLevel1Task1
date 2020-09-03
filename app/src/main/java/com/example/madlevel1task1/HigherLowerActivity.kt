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
        binding.higherB.setOnClickListener { onHigherClick() }
        binding.lowerB.setOnClickListener { onLowerClick() }
        binding.equalB.setOnClickListener { onEqualClick() }

        updateUI()
    }


    private fun updateUI(){
        binding.lastThrowTv.text = getString(R.string.last_throw_text, lastThrow)
        when (currentThrow) {
            1 -> binding.diceIv.setImageResource(R.drawable.dice1)
            2 -> binding.diceIv.setImageResource(R.drawable.dice2)
            3 -> binding.diceIv.setImageResource(R.drawable.dice3)
            4 -> binding.diceIv.setImageResource(R.drawable.dice4)
            5 -> binding.diceIv.setImageResource(R.drawable.dice5)
            6 -> binding.diceIv.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onEqualClick(){
        rollDice()
        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onHigherClick() {
        rollDice()

        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onAnswerCorrect(){
        binding.victoryTv.text = getString(R.string.victory_text)
    }

    private fun onAnswerIncorrect(){
        binding.victoryTv.text = getString(R.string.lose_text)
    }








}
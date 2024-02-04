package com.example.bmicalc

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.bmicalc.databinding.ActivityResultsBinding
import kotlin.math.pow


class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var height: Int = 0
        var weight: Int = 0
        var gender: String = "0"
        binding = ActivityResultsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)//Hides default title
            setHomeAsUpIndicator(R.drawable.back_arrow_4)
        }
        //custom title
        binding.toolbarTitle.text = "BMI Result" //Sets custom title
        val intent = intent
        //Get values from the previous screen
        height = intent.getIntExtra("height", 0)
        weight = intent.getIntExtra("weight", 0)
        binding.resultGender.text = intent.getStringExtra("gender").toString()

        val bmi = weight / (height / 100.0).pow(2.0)
        //get result with two decimal places
        val intBmi = String.format("%.2f", bmi).toFloat()
displayResult(intBmi)
    }
        private fun displayResult(bmi:Float) {
            binding.resultsIndex1.text = bmi.toString()
            when {
                bmi < 16.0 -> binding.resultsIndex1.append("\nSevere Thinness")
                bmi < 16.9 && bmi < 16 -> binding.resultsIndex1.append("\nModerate Thinness")
                bmi < 25 && bmi < 18.5 -> binding.resultsIndex1.append("\nNormal")
                bmi < 25 && bmi > 18.4 -> binding.resultsIndex1.append("\nOver Weight")
                else -> binding.resultsIndex1.append("\nObese")
            }

        }

    }





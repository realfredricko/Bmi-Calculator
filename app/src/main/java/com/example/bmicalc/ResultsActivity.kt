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
   /* private var bmi: String = ""
    private var intBmi: Float = 0.0f
    var height: String = ""
    private var intHeight: Float = 0.0f;
    private var intWeight: Float = 0.0f*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val height = intent.getIntExtra("height", 0)
       val weight = intent.getIntExtra("weight", 0)
       val typeOfUser = intent.getIntExtra("gender",0)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)//Hides default title
            setHomeAsUpIndicator(R.drawable.back_arrow_4)
            //custom title
            binding.toolbarTitle.text = "BMI Result" //Sets custom title
        }
       binding.resultGender
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
         val  bmi = weight / (height / 100.0).pow(2.0)

            //get result with two decimal places
            val intBmi = String.format("%.2f", bmi).toFloat()

            if (intBmi < 16) {
                binding.resultsIndex1.text = "Severe Thinness"
            } else if (intBmi < 16.9 && intBmi > 16) {
                binding.resultsIndex1.text = "Moderate Thinness"
            } else if (intBmi < 25 && intBmi > 18.5) {
                binding.resultsIndex1.text = "Normal"
            } else if (intBmi < 25 && intBmi > 18.4) {
                binding.resultsIndex1.text = "Over Weight"
            } else {
                binding.resultsIndex1.text = "Obese"
            }
       binding.resultsIndex2.text = displayResult(intBmi).toString()
        }
    override fun onSupportNavigateUp(): Boolean{
        onBackPressedDispatcher
        return true
    }

}
        private fun displayResult(intBmi: Float): Float {
            return intBmi
        }



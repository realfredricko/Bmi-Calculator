package com.example.bmicalc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.bmicalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var weight:Int = 55
    private var age:Int =20
    var currentProgress: Int? = null
    private var minProgress:String = "200"
    private var typeOfUser:String = "0"
    private var weight2:String = "55"
    private var age2:String = "20"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()
        binding.BtnCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        if (typeOfUser.equals(0))
        {
            Toast.makeText(MainActivity(), "Something went wrong", Toast.LENGTH_SHORT).show()
        }
        else if (minProgress.equals(0)){
            Toast.makeText(MainActivity(), "Something went wrong", Toast.LENGTH_SHORT).show()
        }
        else if (weight == 0 || weight < 0){
            Toast.makeText(MainActivity(), "Weight is incorrect", Toast.LENGTH_SHORT).show()
        }
        else if (age == 0 || age < 0){
            Toast.makeText(MainActivity(), "Age is incorrect", Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent(this,ResultsActivity::class.java)
            intent.putExtra("weight",weight2)
            intent.putExtra("gender",typeOfUser)
            intent.putExtra("age",age2)
            intent.putExtra("height",minProgress)
            startActivity(intent)
        }
        binding.card1.setOnClickListener {
            binding.card1.setCardBackgroundColor(Color.LTGRAY)
typeOfUser="Male"

    }
        binding.card2.setOnClickListener {
            binding.card2.setCardBackgroundColor(Color.LTGRAY)
            typeOfUser="Female"
        }
        binding.seekbar.max.and(200)
        binding.seekbar.progress = 90
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                currentProgress = progress
                minProgress = currentProgress.toString()
                binding.height1.text = minProgress

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
Toast.makeText(this@MainActivity,
    "Seekbar progress is$currentProgress",
    Toast.LENGTH_SHORT).show()
            }

        })
        binding.imageMinus1.setOnClickListener {
            weight-=1
            weight2 = weight.toString()
            binding.textWeight.text = weight2
        }

        binding.imagePlus1.setOnClickListener{
            weight += 1
            weight2 =weight.toString()
            binding.textWeight.text = weight2
        }
        binding.imageMinus2.setOnClickListener{
            age -= 1
            age2 =age.toString()
            binding.textAge.text = age2
        }
        binding.imagePlus2.setOnClickListener{
            age += 1
            age2 =age.toString()
            binding.textAge.text = age2
        }

}}


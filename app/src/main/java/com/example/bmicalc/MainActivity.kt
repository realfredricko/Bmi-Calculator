package com.example.bmicalc

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    private var cardClickedId:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Changes status bar color
        changesStatusBarColor(R.color.statusBarColor)
        supportActionBar?.hide()
        binding.card1.setOnClickListener {
            handleCardClick(it.id)
                typeOfUser = "Male"
            }


    binding.card2.setOnClickListener {
        handleCardClick(it.id)
        typeOfUser = "Female"
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
        binding.BtnCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun changesStatusBarColor(colorResId:Int) {
        window.statusBarColor=getColor(colorResId)
    }

    private fun handleCardClick(clickedCardId: Int) {
if (cardClickedId == clickedCardId){
    cardClickedId=0
    updateCardUI(binding.card1)
    updateCardUI(binding.card2)
}
        else{
    cardClickedId=clickedCardId
    updateCardUI(binding.card1)
    updateCardUI(binding.card2)
        }
    }

    private fun updateCardUI(cardView: View) {
if (cardView.id == cardClickedId){
    //Updates the UI for selected card state
    /*binding.card1.setCardBackgroundColor(Color.DKGRAY)
    */
    cardView.setBackgroundResource(R.color.selectedCardBackgroundColor)
    binding.textViewMale.setTextColor(getColor(R.color.textClicked))
    binding.imageView.setColorFilter(getColor(R.color.imageClicked))
}
        else{
            //Updates the UI for unselected card state
   /* binding.card2.setCardBackgroundColor(Color.DKGRAY)
    */
            cardView.setBackgroundResource(R.color.defaultCardBackgroundColor)
    binding.textViewFemale.setTextColor(getColor(R.color.unselectedText))
    binding.imageView2.setColorFilter(getColor(R.color.unselectedImage))
        }
    }

    private fun calculateBMI() {
        if (typeOfUser == "0")
        {
            Toast.makeText(MainActivity(), "Something went wrong", Toast.LENGTH_SHORT).show()
        }
        else if (minProgress == "0"){
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
            intent.putExtra("height",currentProgress)
            startActivity(intent)
        }
}
}


package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calcTip(view: View) {
        if (binding.billAmount.text.isNotEmpty()) {
            val bill = binding.billAmount.text.toString().toFloat()
            val ten = bill * 1.1f
            val fifteen = bill * 1.15f
            val twenty = bill * 1.2f

            val tenStr = String.format("%.2f", ten)
            val fifteenStr = String.format("%.2f", fifteen)
            val twentyStr = String.format("%.2f", twenty)

            val out = "The tips are as follows: \n10% = $tenStr\n15% = $fifteenStr\n20% = $twentyStr"
            binding.output.text = out
        } else {
            binding.output.text = getString(R.string.no_value)
        }
    }
}
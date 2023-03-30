package com.example.intentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentproject.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val title = extras.getString("title")
        val detail = extras.getString("detail")
        val image = extras.getInt("image")

        binding.cardtitle.text = title
        binding.detail.text = detail
        binding.imageView.setImageResource(image)
    }
}
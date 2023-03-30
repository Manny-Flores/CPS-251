package com.example.intentproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val placeholder = "PLACEHOLDER"
    private var titles = arrayOf(placeholder,
        placeholder, placeholder, placeholder,
        placeholder, placeholder, placeholder,
        placeholder)

    private var details = arrayOf(placeholder,
        placeholder, placeholder, placeholder,
        placeholder, placeholder, placeholder,
        placeholder)

    private var images = intArrayOf(-1,
        -1, -1,
        -1, -1,
        -1, -1,
        -1)

    fun addTitle(value: String, place: Int) {
        titles[place] = value
    }
    fun addDetail(value: String, place: Int) {
        details[place] = value
    }
    fun addImage(value: Int, place: Int) {
        images[place] = value
    }
    fun getTitles(): Array<String> {
        return titles
    }
    fun getDetails(): Array<String> {
        return details
    }
    fun getImages(): IntArray {
        return images
    }


}
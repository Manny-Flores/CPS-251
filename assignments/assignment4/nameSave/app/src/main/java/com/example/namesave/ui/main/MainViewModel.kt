package com.example.namesave.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var namelist = "No names to display"
    fun setList(value: String) {
        namelist = value
    }
    fun getResult(): String {
        return namelist
    }
}
package com.example.namesave2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var namelist: MutableLiveData<String> = MutableLiveData("No names to display")

    fun setList(value: String) {
        namelist.setValue(value.toString())
    }
    fun getResult(): MutableLiveData<String> {
        return namelist
    }
}
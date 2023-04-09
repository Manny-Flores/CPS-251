package com.example.coroutineproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var names = ArrayList<String>()

    fun getNames(): ArrayList<String> {
        return names
    }

    fun addNames(name : String) {
        names.add(name)
    }


}
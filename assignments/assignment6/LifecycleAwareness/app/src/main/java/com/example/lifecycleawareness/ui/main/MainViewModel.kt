package com.example.lifecycleawareness.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle

const val TEXT_KEY = "Text"

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var text: MutableLiveData<String> = savedStateHandle.getLiveData(TEXT_KEY)
    init{
        if(text.value == null){
            text.setValue("")
        }
    }
    fun setText(value: String) {
        text.setValue(value.toString())
        savedStateHandle.set(TEXT_KEY, value)
        println("value of key is: " + savedStateHandle.get(TEXT_KEY))
    }
    fun getResult(): MutableLiveData<String> {
        return text
    }
}
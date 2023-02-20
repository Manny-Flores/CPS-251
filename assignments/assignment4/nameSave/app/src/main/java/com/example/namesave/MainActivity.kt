package com.example.namesave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.namesave.ui.main.MainFragment

class MainActivity : FragmentActivity(), MainFragment.ButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
    fun addName(view: View) {

    }

    override fun onButtonClick(input: String, text: String) {
        var out = text;
        if(out == "No names to display"){
            out = ""
        }
        out = out + input + "\n"
        val mainFragment = supportFragmentManager.findFragmentById(R.id.container) as MainFragment
        mainFragment.addName(out)
    }
}
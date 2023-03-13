package com.example.lifecycleawareness

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.lifecycleawareness.ui.main.MainFragment
import java.text.SimpleDateFormat

class DemoObserver: DefaultLifecycleObserver {
    private val LOG_TAG = "CustomObserver"
    private val template = " was fired on "
    private val sdf = SimpleDateFormat("HH:mm:ss.SSS")

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        var out = "onResume" + template + sdf.format(java.sql.Timestamp(System.currentTimeMillis())) + "\n **********"
        (owner as MainFragment).addText(out)
        //Log.i(LOG_TAG, "Custom Observer onResume")
    }

    override fun onPause(owner: LifecycleOwner){
        super.onPause(owner)

        var out = "onPause" + template + sdf.format(java.sql.Timestamp(System.currentTimeMillis())) + "\n **********"
        (owner as MainFragment).addText(out)
        //Log.i(LOG_TAG, "Custom Observer onPause")
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        var out = "onCreate" + template + sdf.format(java.sql.Timestamp(System.currentTimeMillis()))
        (owner as MainFragment).addText(out)
        //Log.i(LOG_TAG, "Custom Observer onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        var out = "onStart" + template + sdf.format(java.sql.Timestamp(System.currentTimeMillis()))
        (owner as MainFragment).addText(out)
        //Log.i(LOG_TAG, "Custom Observer onCreate")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        var out = "onStop" + template + sdf.format(java.sql.Timestamp(System.currentTimeMillis()))
        (owner as MainFragment).addText(out)
        //Log.i(LOG_TAG, "Custom Observer onCreate")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        var out = "onDestroy" + template + sdf.format(java.sql.Timestamp(System.currentTimeMillis())) + "\n **********"
        (owner as MainFragment).addText(out)
        //Log.i(LOG_TAG, "Custom Observer onCreate")
    }
}
package com.example.coroutineproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineproject.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        (adapter as RecyclerAdapter).setViewModel(viewModel)
        (adapter as RecyclerAdapter).setNames(viewModel.getNames())
        binding.contentMain.recyclerView.layoutManager = adapter
    }

    fun startCoroutine(v: View){
        coroutineScope.launch(Dispatchers.Main) {
            val delay = (1..10).random() * 1000
            var string = addName(binding.enterName.text.toString(), delay.toLong())
            (adapter as RecyclerAdapter).add(string.await())
        }
    }

    suspend fun addName(name : String, delay : Long): Deferred<String> =
        coroutineScope.async(Dispatchers.Main) {
            delay(delay)
            return@async "The name is $name and the delay was $delay ms"
        }
}
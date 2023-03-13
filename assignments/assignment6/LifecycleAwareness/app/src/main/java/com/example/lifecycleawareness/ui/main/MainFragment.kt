package com.example.lifecycleawareness.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleawareness.DemoObserver
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import com.example.lifecycleawareness.R
import com.example.lifecycleawareness.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(this)
        binding.setVariable(1, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = SavedStateViewModelFactory(activity?.application, this)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        lifecycle.addObserver(DemoObserver())

    }

    fun addText(text: String){
        val out = viewModel.getResult().value.toString() + "\n" + text
        viewModel.setText(out)
    }
}
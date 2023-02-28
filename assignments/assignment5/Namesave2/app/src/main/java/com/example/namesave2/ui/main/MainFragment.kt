package com.example.namesave2.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.namesave2.R
import com.example.namesave2.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    var activityCallback: ButtonListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(this)
        var mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(1, viewModel)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.textView.text = viewModel.getResult().toString()
        binding.button.setOnClickListener { v: View -> onClick(v) }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ButtonListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " must implement ToolbarListener"
            )
        }
    }

    fun addName(name: String) {
        //binding.textView.text = name
        viewModel.setList(name)
    }

    interface ButtonListener {
        fun onButtonClick(input: String, text: String)
    }

    override fun onClick(view: View) {
        activityCallback?.onButtonClick(binding.editTextTextPersonName2.text.toString(), binding.textView.text.toString())
    }


}

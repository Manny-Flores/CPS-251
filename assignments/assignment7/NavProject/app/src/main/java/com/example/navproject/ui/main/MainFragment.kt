package com.example.navproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navproject.R
import com.example.navproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //binding.img1.setOnClickListener {
            //val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond("Image 1")
            //action.setMessage(binding.userText.text.toString())
            //Navigation.findNavController(it).navigate(action)
        //}

        binding.img1.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond(R.drawable.android_image_1)
            action.setMessage("Image 1")
            action.setImage(R.drawable.android_image_1)
            Navigation.findNavController(it).navigate(action)
        }
        binding.img2.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond(R.drawable.android_image_2)
            action.setMessage("Image 2")
            action.setImage(R.drawable.android_image_2)
            Navigation.findNavController(it).navigate(action)
        }
        binding.img3.setOnClickListener{
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond(R.drawable.android_image_3)
            action.setMessage("Image 3")
            action.setImage(R.drawable.android_image_3)
            Navigation.findNavController(it).navigate(action)
        }
    }
}
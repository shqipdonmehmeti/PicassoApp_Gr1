package com.example.picassoapp_gr1.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.picassoapp_gr1.R
import com.example.picassoapp_gr1.databinding.FragmentHomeDetailsBinding


class HomeDetailsFragment : Fragment() {

    private lateinit var binding : FragmentHomeDetailsBinding
    private val args : HomeDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "args: ${args.flagDesc}")
    }


}
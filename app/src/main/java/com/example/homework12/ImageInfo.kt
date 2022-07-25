package com.example.homework12

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.homework12.databinding.FragmentImageInfoBinding


class ImageInfo : Fragment() {


    private var binding: FragmentImageInfoBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageInfoBinding.inflate(layoutInflater)
        val args: ImageInfoArgs by navArgs()
        val image = args.image
        image.apply {
            binding!!.name.text = name
            binding!!.description.text = description
            Glide.with(context as Context).load(url).into(binding!!.image)
        }
        return binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
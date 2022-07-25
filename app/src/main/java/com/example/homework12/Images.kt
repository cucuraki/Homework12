package com.example.homework12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.homework12.databinding.FragmentImagesBinding

class Images : Fragment() {
    private var binding: FragmentImagesBinding? = null
    private lateinit var adapter: Adapter

    companion object {
        private lateinit var list: MutableList<Image>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = Adapter(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImagesBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        adapter.setOnClickListener {
            onImageClicked(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initRecycler() {
        list = mutableListOf(
            Image(1, "name1", getString(R.string.image1), "This is image 1"),
            Image(2, "jemala", getString(R.string.image2), "This is jemala"),
            Image(3, "saxeli", getString(R.string.image1), "surati 3"),
            Image(4, "surati", getString(R.string.image1), "4"),
            Image(5, "nam3", getString(R.string.image2), "This is image 1"),
            Image(6, "jemalqa", getString(R.string.image1), "This is jemala"),
            Image(7, "saxel4i", getString(R.string.image1), "surati 3"),
            Image(8, "surati0", getString(R.string.image2), "4"),
            Image(9, "name1", getString(R.string.image1), "This is image 1"),
            Image(10, "jemala", getString(R.string.image2), "This is jemala"),
            Image(11, "saxeli", getString(R.string.image2), "surati 3"),
            Image(12, "surati", getString(R.string.image1), "4"),
            Image(13, "nam3", getString(R.string.image1), "This is image 1"),
            Image(14, "jemalqa", getString(R.string.image1), "This is jemala"),
            Image(15, "saxel4i", getString(R.string.image1), "surati 3"),
            Image(16, "surati0", getString(R.string.image2), "4")
        )
        adapter.submitList(list)
        binding!!.recycler.adapter = adapter
        this.setRecyclerViewAndList(binding!!.recycler, list)
        binding!!.recycler.layoutManager = GridLayoutManager(this.requireContext(), 3)
    }

    private fun onImageClicked(position: Int) {
        this.findNavController().navigate(ImagesDirections.actionImagesToImageInfo(list[position]))
    }
}
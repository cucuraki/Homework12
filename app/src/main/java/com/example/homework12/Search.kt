package com.example.homework12

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.homework12.databinding.FragmentSearchBinding

class Search : Fragment(), Getters {

    private var binding: FragmentSearchBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.search.doOnTextChanged { text , _, _,_->
            val recycler = this@Search.getRecyclerView()
            (recycler?.adapter as Adapter).submitList(this@Search.getList()?.filter { it.name.contains(text.toString()) })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
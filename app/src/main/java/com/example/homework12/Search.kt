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
import com.example.homework12.databinding.FragmentSearchBinding

class Search : Fragment() {

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
        binding!!.search.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                return
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                return
            }

            override fun afterTextChanged(p0: Editable?) {
                val recycler = this@Search.getRecyclerView()
                (recycler?.adapter as Adapter).submitList(this@Search.getList()?.filter { it.name.contains(p0.toString()) })
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
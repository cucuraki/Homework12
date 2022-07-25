package com.example.homework12

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework12.databinding.ImageItemBinding

class Adapter(private val context: Context) :
    ListAdapter<Image, Adapter.MyViewHolder>(MyDiffUtil()) {
    private lateinit var listener: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ImageItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(getItem(position).url).into(holder.image)

    }

    fun setOnClickListener(listener: (Int) -> Unit){
        this.listener = listener
    }
    inner class MyViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.image

        init {
            if(!this@Adapter::listener.isInitialized)
                listener = {}
            image.setOnClickListener{
                listener(adapterPosition)
            }
        }
    }

}
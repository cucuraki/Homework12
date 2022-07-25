package com.example.homework12

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(): DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Image, newItem: Image) = oldItem == newItem

}
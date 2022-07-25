package com.example.homework12

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


private lateinit var recyclerView: RecyclerView
private lateinit var list: MutableList<Image>
fun Fragment.setRecyclerViewAndList(recyclerView1: RecyclerView, list1: MutableList<Image>) {
    recyclerView = recyclerView1
    list = list1
}

fun Fragment.getRecyclerView(): RecyclerView? =
    if (::recyclerView.isInitialized) {
        recyclerView
    } else {
        null
    }

fun Fragment.getList(): MutableList<Image>? =
    if (::list.isInitialized) list else null

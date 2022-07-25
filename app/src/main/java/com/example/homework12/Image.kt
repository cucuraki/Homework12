package com.example.homework12

import android.os.Parcelable
import java.io.Serializable

data class Image(val id: Int, var name: String, var url: String, var description: String): Serializable
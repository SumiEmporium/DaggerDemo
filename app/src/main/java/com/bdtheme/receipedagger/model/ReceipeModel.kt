package com.bdtheme.receipedagger.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReceipeModel(
    val title: String,
    val photoUrl: String,
    val prepTime: Int,
    val cookTime: Int,
    val totalTime: Int,
    val directions: String,
    val ingredients: String
) : Parcelable

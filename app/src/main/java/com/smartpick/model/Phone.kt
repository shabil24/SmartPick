package com.smartpick.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone(
    val imageResId: Int,
    val merek: String,
    val brand: String,
    val harga: String,
    val rating: Int,
    val deskripsi: String,
    val spesifikasi: String,
    val kebutuhan: List<String>,
    val tersedia: Boolean,
    var isSelected: Boolean = false

) : Parcelable

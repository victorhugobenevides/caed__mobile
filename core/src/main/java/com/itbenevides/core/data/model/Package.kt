package com.itbenevides.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Package(
    val code: String,
    val deliveryPoint: String,
    val city: String,
    val state: String,
    val status: List<Status>,
) : Parcelable

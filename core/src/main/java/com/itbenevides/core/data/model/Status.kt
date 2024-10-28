package com.itbenevides.core.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Status(val data: String, val hour: String, val description: String) : Parcelable

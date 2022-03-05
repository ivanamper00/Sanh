package com.dakuinternational.common.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataContent(
    var title: String,
    var description: String,
    var asset: String? = "",
    @DrawableRes var resourceIcon: Int? = 0,
) : Parcelable

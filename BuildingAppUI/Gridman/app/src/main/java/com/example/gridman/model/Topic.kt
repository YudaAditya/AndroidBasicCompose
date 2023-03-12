package com.example.gridman.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val avaliableCourses: Int,
    @DrawableRes val imageRes: Int
)

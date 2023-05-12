package com.loodos.samplecomposeandroid.core.data.model.category

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color


/**
 * Created by Murat Korkmazoğlu on 8.05.2023.
 * Loodos
 * murat.korkmazoglu@loodos.com
 */
data class CardItem(
    val title: String,
    @DrawableRes val iconId: Int
)

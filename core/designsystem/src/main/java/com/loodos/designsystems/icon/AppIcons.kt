package com.loodos.designsystems.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Loodos Sample App in Android icons. Material icons are [ImageVector]s, custom icons are drawable resource IDs.
 */
object AppIcons {
    val Home = Icons.Default.Home
    val HomeOutlined = Icons.Outlined.Home
    val Category = Icons.Default.Category
    val CategoryOutlined = Icons.Outlined.Category
    val Person = Icons.Default.Person
    val PersonOutlined = Icons.Outlined.Person
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
@Stable
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}

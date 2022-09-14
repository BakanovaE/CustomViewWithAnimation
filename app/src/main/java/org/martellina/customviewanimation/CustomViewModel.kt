package org.martellina.customviewanimation

import androidx.annotation.DrawableRes
import androidx.dynamicanimation.animation.SpringForce

data class CustomViewModel(
    val author: String,
    val title: String,
    @DrawableRes val cover: Int,
    val genre: GenreName,
    val animation: AnimationModel?
)

enum class GenreName(val fullName: String, @DrawableRes val icon: Int) {
    FANTASY("Fantasy", R.drawable.ic_baseline_menu_book_24),
    NON_FIC("Non-fiction", R.drawable.ic_baseline_bookmarks_24),
    SCIENCE_FIC("Science-fiction", R.drawable.ic_baseline_book_24)
}

data class AnimationModel(
    val animationType: AnimationType,
    val hasVibration: Boolean,
    val durationVibration: Long?
)

enum class AnimationType(val stiffness: Float, val dampingRatio: Float) {
    LOW(SpringForce.STIFFNESS_LOW, SpringForce.DAMPING_RATIO_HIGH_BOUNCY),
    MEDIUM(SpringForce.STIFFNESS_MEDIUM, SpringForce.DAMPING_RATIO_HIGH_BOUNCY),
    HIGH(SpringForce.STIFFNESS_HIGH, SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
}

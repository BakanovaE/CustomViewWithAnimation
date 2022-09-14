package org.martellina.customviewanimation

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import org.martellina.customviewanimation.databinding.CustomViewBinding

private const val MIN_ANIMATION_VALUE = -40F
private const val START_ANIMATION_VALUE = 40F
private const val FINAL_POSITION = 0F

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding by unsafeLazy {
        CustomViewBinding.bind(this)
    }

    init {
        inflate(context, R.layout.custom_view, this)
    }

    fun populate(model: CustomViewModel) {
        setUpBackground()
        setUpCover(model.cover)
        setUpGenre(model.genre)
        setUpAuthor(model.author)
        setUpTitle(model.title)

        model.animation?.let {
            binding.root.setOnClickListener {
                with(model.animation) {
                    animate(animationType)
                    if (hasVibration) {
                        this.durationVibration?.let { durationVibration ->
                            binding.root.addVibration(durationVibration)
                        }
                    }
                }
            }
        }
    }

    private fun setUpCover(cover: Int) {
        binding.bookCover.setImageResource(cover)
    }

    private fun setUpBackground() {
        binding.root.background = ContextCompat.getDrawable(context, R.drawable.background_round_corners)
    }

    private fun setUpTitle(title: String) {
        binding.title.text = title
    }

    private fun setUpAuthor(author: String) {
        binding.author.text = author
    }

    private fun setUpGenre(genre: GenreName) {
        binding.genreName.text = genre.fullName
        binding.genreIcon.setImageResource(genre.icon)
    }

    private fun animate(animationType: AnimationType) {
        val spring = SpringForce(FINAL_POSITION)
            .setStiffness(animationType.stiffness)
            .setDampingRatio(animationType.dampingRatio)

        SpringAnimation(this, DynamicAnimation.X).apply {
            setMinValue(MIN_ANIMATION_VALUE)
            setSpring(spring)
            setStartValue(START_ANIMATION_VALUE)
            start()
        }
    }
}

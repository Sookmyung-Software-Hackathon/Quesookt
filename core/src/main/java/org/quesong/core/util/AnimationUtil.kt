package org.quesong.core.util

import android.animation.ObjectAnimator
import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import org.quesong.core.R

object AnimationUtil {
    fun setProgressAnimation(progressBar: ProgressBar, progress : Int) {
        ObjectAnimator.ofInt(progressBar, "progress", progress)
            .setDuration(SHOW_TIME)
            .start()
    }

    fun Context.getFadeInAnim(): Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in_1000)

    private const val ONE_SECOND = 1000L
    private const val SHOW_TIME = 500L
}
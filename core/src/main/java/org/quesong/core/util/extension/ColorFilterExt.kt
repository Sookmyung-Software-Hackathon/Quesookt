package org.quesong.core.util.extension

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import org.quesong.core.R

fun ImageView.setImgFilter30() {
    colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
        ContextCompat.getColor(
            context,
            R.color.main_black_alpha30
        ), BlendModeCompat.SRC_OVER
    )
}

fun ImageView.setImgFilter20() {
    colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
        ContextCompat.getColor(
            context,
            R.color.main_black_alpha20
        ), BlendModeCompat.SRC_OVER
    )
}

package org.quesong.quesookt.util

import android.app.Application
import androidx.annotation.Px
import org.quesong.quesookt.QuesooktApplication
import kotlin.math.roundToInt

class PixelRatio(private val app: Application) {
    private val displayMetrics
        get() = app.resources.displayMetrics

    @Px
    fun toPixel(dp: Int) = (dp * displayMetrics.density).roundToInt()
}

val Number.dp: Int
    get() = QuesooktApplication.pixelRatio.toPixel(this.toInt())
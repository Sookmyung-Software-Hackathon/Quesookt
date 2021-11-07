package org.quesong.core.util

import android.content.res.Resources
import android.util.TypedValue
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

object BindingAdapter {
    @JvmStatic
    @androidx.databinding.BindingAdapter("remoteRoundedImg")
    fun setRemoteRoundedImg(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).transform(
            CenterCrop(),
            RoundedCorners(
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    IMAGE_RADIUS.toFloat(),
                    Resources.getSystem().displayMetrics
                ).toInt()
            )
        ).into(imageView)
    }

    @JvmStatic
    @androidx.databinding.BindingAdapter("remoteImgUrl")
    fun setRemoteImg(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).transform(
            CenterCrop()
        ).into(imageView)
    }

    const val IMAGE_RADIUS = 20
}
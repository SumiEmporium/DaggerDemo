package com.bdtheme.receipedagger.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bdtheme.receipedagger.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("image")
fun loadImage(image: ImageView, url: String) {
    Glide.with(image)
            .load(url)
            .apply(RequestOptions.placeholderOf(R.drawable.defalt)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .error(R.drawable.defalt)
            .into(image)
}

@BindingAdapter("circleimage")
fun loadCircleImage(image: ImageView, url: String) {
    Glide.with(image).load(url).apply(RequestOptions().circleCrop().placeholder(R.drawable.defalt)
            .error(R.drawable.defalt)).into(image)
}

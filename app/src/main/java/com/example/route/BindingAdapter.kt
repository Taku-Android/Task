package com.example.route

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide



object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImageFromUrl(
        imageView: ImageView,
        url: String?
    ) {
        if (url == null) {
            imageView.setImageResource(R.drawable.loading)
        } else if (url != imageView.tag) {
            imageView.tag = url
            Glide.with(imageView.context)
                .load(url)
                .into(imageView)
        }
    }
}






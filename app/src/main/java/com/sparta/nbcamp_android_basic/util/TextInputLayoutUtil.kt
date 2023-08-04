package com.sparta.nbcamp_android_basic.util

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import com.sparta.nbcamp_android_basic.R
fun shake(editText: EditText, context: Context) {
    val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.shake)
    editText.startAnimation(animation)
    editText.requestFocus()
}
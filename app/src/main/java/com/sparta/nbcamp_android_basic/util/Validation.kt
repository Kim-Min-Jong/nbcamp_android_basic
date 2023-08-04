package com.sparta.nbcamp_android_basic.util

import android.content.Context
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.sparta.nbcamp_android_basic.R

fun validateEmpty(inputLayout: TextInputLayout, str: String, message:String): Boolean {
    return if (str == "") {
        inputLayout.error = message
        false
    } else {
        initValidate(inputLayout)
        true
    }
}

fun initValidate(inputLayout: TextInputLayout) {
    inputLayout.apply {
        error = null
        isErrorEnabled = false
    }
}
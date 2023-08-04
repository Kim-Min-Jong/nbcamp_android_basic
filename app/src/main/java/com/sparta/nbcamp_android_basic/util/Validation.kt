package com.sparta.nbcamp_android_basic.util

import android.content.Context
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.sparta.nbcamp_android_basic.R

fun validateConfirm(inputTextLayout: TextInputLayout, editText: EditText, context: Context, message: String) {
    validate(inputTextLayout, message)
    shake(editText, context)
}

fun validateEmpty(inputLayout: TextInputLayout, str: String, message:String): Boolean {
    return if (str == "") {
        inputLayout.error = message
        validate(inputLayout, message)
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
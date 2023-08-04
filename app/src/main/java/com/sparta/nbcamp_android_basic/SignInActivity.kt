package com.sparta.nbcamp_android_basic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.sparta.nbcamp_android_basic.util.shake
import com.sparta.nbcamp_android_basic.util.toast
import com.sparta.nbcamp_android_basic.util.validate
import com.sparta.nbcamp_android_basic.util.validateConfirm
import com.sparta.nbcamp_android_basic.util.validateEmpty

class SignInActivity : AppCompatActivity() {
    private val editTextId by lazy { findViewById<EditText>(R.id.editTextId) }
    private val editTextPwd by lazy { findViewById<EditText>(R.id.editTextTextPassword) }
    private val btnLogIn by lazy { findViewById<Button>(R.id.buttonLogIn) }
    private val btnSignIn by lazy { findViewById<Button>(R.id.buttonSignIn) }
    private val textInputId by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutId) }
    private val textInputPwd by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutPwd) }
    private var id: String = ""
    private var pwd: String = ""
    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val id = it.data?.getStringExtra("ID")
                val pwd = it.data?.getStringExtra("PWD")
                editTextId.setText(id)
                editTextPwd.setText(pwd)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initButton()
        initEditText()
    }

    private fun initButton() {
        btnLogIn.setOnClickListener {
            if(!checkValidation()) {
                toast(getString(R.string.check_id_pwd))
                return@setOnClickListener
            }
            startActivity(Intent(this, HomeActivity::class.java).apply {
                putExtra("ID", id)
                textInputId.apply {
                    error = null
                    isErrorEnabled = false
                }
                textInputPwd.apply {
                    error = null
                    isErrorEnabled = false
                }
            })
            toast(getString(R.string.log_in_success))
        }
        btnSignIn.setOnClickListener {
            activityLauncher.launch(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun initEditText() {
        editTextId.doOnTextChanged { text, _, _, _ ->
            id = text.toString()
        }
        editTextPwd.doOnTextChanged { text, _, _, _ ->
            pwd = text.toString()
        }
    }

    private fun checkValidation(): Boolean {
        var check = true
        if (!validateEmpty(textInputId, id, getString(R.string.check_id))) {
            shake(editTextId, this@SignInActivity)
            check = false
        }
        if (!validateEmpty(textInputPwd, pwd, getString(R.string.check_pwd))) {
            shake(editTextPwd, this@SignInActivity)
            check = false
        }

        return check
    }
}

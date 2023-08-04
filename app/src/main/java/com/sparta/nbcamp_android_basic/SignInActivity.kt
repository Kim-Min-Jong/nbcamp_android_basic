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

class SignInActivity : AppCompatActivity() {
    private val editTextId by lazy { findViewById<EditText>(R.id.editTextId) }
    private val editTextPwd by lazy { findViewById<EditText>(R.id.editTextTextPassword) }
    private val btnLogIn by lazy { findViewById<Button>(R.id.buttonLogIn) }
    private val btnSignIn by lazy { findViewById<Button>(R.id.buttonSignIn) }
    private val textInputId by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutId)}
    private val textInputPwd by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutPwd)}
    private lateinit var id: String
    private lateinit var pwd: String
    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK) {
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
            if((::id.isInitialized.not() && ::pwd.isInitialized.not()) || (id == "" && pwd == "")) {
                toast(getString(R.string.check_id_pwd))
                validate(textInputId, getString(R.string.do_not_input_id))
                validate(textInputPwd, getString(R.string.do_not_input_pwd))
                shake(editTextId, this)
                shake(editTextPwd, this)
                return@setOnClickListener
            }
            else if((::id.isInitialized.not() && ::pwd.isInitialized) || id == "") {
                toast(getString(R.string.check_id))
                validate(textInputId,getString(R.string.do_not_input_id))
                textInputPwd.apply {
                    error = null
                    isErrorEnabled = false
                }
                shake(editTextId, this)
                return@setOnClickListener
            }
            else if((::id.isInitialized && ::pwd.isInitialized.not()) || pwd == ""){
                toast(getString(R.string.check_pwd))
                editTextId.error = null
                validate(textInputPwd, getString(R.string.do_not_input_pwd))
                textInputId.apply {
                    error = null
                    isErrorEnabled = false
                }
                shake(editTextPwd, this)
                return@setOnClickListener
            }
            startActivity(Intent(this, HomeActivity::class.java).apply {
                putExtra("ID", id)
                editTextId.error = null
                editTextPwd.error = null
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


}
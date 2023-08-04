package com.sparta.nbcamp_android_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.sparta.nbcamp_android_basic.model.User
import com.sparta.nbcamp_android_basic.util.toast
import com.sparta.nbcamp_android_basic.util.validate


class SignUpActivity : AppCompatActivity() {
    private val editTextName by lazy { findViewById<EditText>(R.id.editTextName)}
    private val editTextId by lazy { findViewById<EditText>(R.id.editTextSignId)}
    private val editTextPwd by lazy { findViewById<EditText>(R.id.editTextTextSignPassword)}
    private val btnSignIn by lazy {findViewById<Button>(R.id.buttonSignLogIn)}
    private val textInputId by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutId)}
    private val textInputPwd by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutPwd)}
    private val textInputName by lazy { findViewById<TextInputLayout>(R.id.textInputLayoutName)}
    private lateinit var name: String
    private lateinit var id: String
    private lateinit var pwd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initEditText()
        initButton()
    }

    private fun initButton() {
        btnSignIn.setOnClickListener {
            if(::name.isInitialized.not() || ::id.isInitialized.not() || ::pwd.isInitialized.not()) {
                toast(getString(R.string.empty_info_exist))
                return@setOnClickListener
            }
            if(list.count{ it.id == id } >= 1) {
                toast(getString(R.string.duplicated_id))
                return@setOnClickListener
            }
            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("ID", id)
                putExtra("PWD",pwd)
            }
            list.add(User(id, pwd))
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun initEditText() {
        editTextName.doOnTextChanged { text, _, _, _ ->
            name = text.toString()
        }
        editTextId.doOnTextChanged { text, _, _, _ ->
            id = text.toString()
        }
        editTextPwd.doOnTextChanged { text, _, _, _ ->
            pwd = text.toString()
        }
    }
    companion object {
        val list = mutableListOf<User>()
    }
}
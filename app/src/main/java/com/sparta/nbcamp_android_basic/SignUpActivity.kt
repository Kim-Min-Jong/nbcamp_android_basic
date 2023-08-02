package com.sparta.nbcamp_android_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.sparta.nbcamp_android_basic.util.toast

class SignUpActivity : AppCompatActivity() {
    private val editTextName by lazy { findViewById<EditText>(R.id.editTextName)}
    private val editTextId by lazy { findViewById<EditText>(R.id.editTextSignId)}
    private val editTextPwd by lazy { findViewById<EditText>(R.id.editTextTextSignPassword)}
    private val btnSignIn by lazy {findViewById<Button>(R.id.buttonSignLogIn)}
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
                toast("입력되지 않은 정보가 있습니다.")
                return@setOnClickListener
            }
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
}
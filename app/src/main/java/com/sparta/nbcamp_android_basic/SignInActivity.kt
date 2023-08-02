package com.sparta.nbcamp_android_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.sparta.nbcamp_android_basic.util.toast

class SignInActivity : AppCompatActivity() {
    private val editTextId by lazy { findViewById<EditText>(R.id.editTextId) }
    private val editTextPwd by lazy { findViewById<EditText>(R.id.editTextTextPassword) }
    private val btnLogIn by lazy { findViewById<Button>(R.id.buttonLogIn) }
    private val btnSignIn by lazy { findViewById<Button>(R.id.buttonSignIn) }
    private lateinit var id: String
    private lateinit var pwd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initButton()
        initEditText()
    }
    private fun initButton() {
        btnLogIn.setOnClickListener {
            if(::id.isInitialized.not() || ::pwd.isInitialized.not() || pwd == "" || id == "") {
                toast("아이디/비밀번호를 확인해주세요")
                return@setOnClickListener
            }
            startActivity(Intent(this, HomeActivity::class.java).apply {
                putExtra("ID", id)
                putExtra("PWD", pwd)

            })
            toast("로그인 성공")
        }
        btnSignIn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
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
package com.sparta.nbcamp_android_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private val textViewId by lazy { findViewById<TextView>(R.id.textView9)}
    private val textView10 by lazy { findViewById<TextView>(R.id.textView10)}
    private val textView11 by lazy { findViewById<TextView>(R.id.textView11)}
    private val textView12 by lazy { findViewById<TextView>(R.id.textView12)}
    private val btnEnd by lazy { findViewById<Button>(R.id.buttonEnd) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("ID")
        textViewId.text = id.toString()
        textView10.text = "김민종"
        textView11.text = "만 25세"
        textView12.text = "ISTJ"

        btnEnd.setOnClickListener {
            finish()
        }
    }
}
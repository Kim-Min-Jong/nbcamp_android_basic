package com.sparta.nbcamp_android_basic

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    private val textViewId by lazy { findViewById<TextView>(R.id.textView9)}
    private val textView10 by lazy { findViewById<TextView>(R.id.textView10)}
    private val textView11 by lazy { findViewById<TextView>(R.id.textView11)}
    private val textView12 by lazy { findViewById<TextView>(R.id.textView12)}
    private val imageView by lazy { findViewById<ImageView>(R.id.imageView2)}
    private val btnEnd by lazy { findViewById<Button>(R.id.buttonEnd) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("ID")
        val imgList = listOf(
            R.drawable.rtan1,
            R.drawable.rtan2,
            R.drawable.rtan3,
            R.drawable.rtan4,
            R.drawable.rtan5,
        )
        val randomInt = Random.nextInt(5)

        imageView.setImageResource(imgList[randomInt])
        textViewId.text = id.toString()
        textView10.text = "김민종"
        textView11.text = "만 25세"
        textView12.text = "ISTJ"

        btnEnd.setOnClickListener {
            finish()
        }
    }
}
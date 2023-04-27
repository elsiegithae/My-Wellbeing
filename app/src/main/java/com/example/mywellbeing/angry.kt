package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class angry : AppCompatActivity() {
    lateinit var mDone: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angry)

        mDone=findViewById(R.id.mBtnDone1)

        mDone.setOnClickListener {
            val tembea= Intent(this@angry, MainActivity::class.java)
            startActivity(tembea)
        }

    }
}
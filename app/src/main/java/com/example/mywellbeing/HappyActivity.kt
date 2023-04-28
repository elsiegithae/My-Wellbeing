package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HappyActivity : AppCompatActivity() {
    lateinit var mDone :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy)
        mDone=findViewById(R.id.mBtnDone)

        mDone.setOnClickListener {
            val tembea= Intent(this@HappyActivity, MainActivity::class.java)
            startActivity(tembea)
        }

    }
}
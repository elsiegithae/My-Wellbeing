package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class rad : AppCompatActivity() {
    lateinit var mDone : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rad)

        mDone=findViewById(R.id.mBtnDone2)

        mDone.setOnClickListener {
            val tembea= Intent(this@rad, MainActivity::class.java)
            startActivity(tembea)
        }


    }
}
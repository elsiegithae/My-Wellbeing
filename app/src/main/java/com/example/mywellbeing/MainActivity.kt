package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var mHappy : Button
    lateinit var mAngry :Button
    lateinit var mRad :Button
    lateinit var mSad :Button
    lateinit var mUnhappy :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHappy=findViewById(R.id.btnHappy)
        mAngry=findViewById(R.id.btnAngry)
        mRad=findViewById(R.id.btnRad)
        mSad=findViewById(R.id.btnSad)
        mUnhappy=findViewById(R.id.btnUnhappy)


        mHappy.setOnClickListener {
            val tembea= Intent(this@MainActivity, happy::class.java)
            startActivity(tembea)
        }

        mAngry.setOnClickListener {
            val tembea= Intent(this@MainActivity, angry::class.java)
            startActivity(tembea)
        }



    }
}
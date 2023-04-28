package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RadActivity : AppCompatActivity() {
    lateinit var mDone : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rad)

        mDone=findViewById(R.id.mBtnDone2)

        mDone.setOnClickListener {
            val tembea= Intent(this@RadActivity, MainActivity::class.java)
            startActivity(tembea)
        }


    }
}
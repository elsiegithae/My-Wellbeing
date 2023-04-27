package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class unhappy : AppCompatActivity() {
    lateinit var mDone : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unhappy)

        mDone=findViewById(R.id.mBtnDone4)

        mDone.setOnClickListener {
            val tembea= Intent(this@unhappy, MainActivity::class.java)
            startActivity(tembea)
        }



    }
}
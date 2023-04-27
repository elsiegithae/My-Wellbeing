package com.example.mywellbeing

import android.content.Intent
import android.database.sqlite.SQLiteDoneException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class sad : AppCompatActivity() {
    lateinit var mDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sad)

        mDone = findViewById(R.id.mBtnDone3)

        mDone.setOnClickListener {
            val tembea= Intent(this@sad, MainActivity::class.java)
            startActivity(tembea)
        }


    }
}
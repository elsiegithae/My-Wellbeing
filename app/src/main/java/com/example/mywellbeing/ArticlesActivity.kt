package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ArticlesActivity : AppCompatActivity() {
    lateinit var mBtnWeb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        mBtnWeb=findViewById(R.id.webLink)

        mBtnWeb.setOnClickListener {
            val tembea= Intent(this@ArticlesActivity, WebsiteActivity::class.java)
            startActivity(tembea)
        }
    }
}
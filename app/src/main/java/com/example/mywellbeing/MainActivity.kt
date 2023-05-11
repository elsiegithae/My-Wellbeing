package com.example.mywellbeing

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var mHappy : Button
    lateinit var mAngry :Button
    lateinit var mRad :Button
    lateinit var mSad :Button
    lateinit var mUnhappy :Button
    lateinit var mHotline : Button
    lateinit var mHelpline : Button
    lateinit var mAddArticle:Button
    lateinit var mArticle:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHappy=findViewById(R.id.btnHappy)
        mAngry=findViewById(R.id.btnAngry)
        mRad=findViewById(R.id.btnRad)
        mSad=findViewById(R.id.btnSad)
        mUnhappy=findViewById(R.id.btnUnhappy)
        mHotline=findViewById(R.id.btnHotline)
        mHelpline=findViewById(R.id.btnHelpline)
        mAddArticle=findViewById(R.id.btnAddArticle)
        mArticle=findViewById(R.id.btnArticles)



        mHappy.setOnClickListener {
            val tembea= Intent(this@MainActivity, HappyActivity::class.java)
            startActivity(tembea)
        }
        mArticle.setOnClickListener {
            val tembea= Intent(this@MainActivity, ArticlesActivity::class.java)
            startActivity(tembea)
        }

        mAngry.setOnClickListener {
            val tembea= Intent(this@MainActivity, AngryActivity::class.java)
            startActivity(tembea)
        }

        mRad.setOnClickListener {
            val tembea= Intent(this@MainActivity, RadActivity::class.java)
            startActivity(tembea)
        }

        mUnhappy.setOnClickListener {
            val tembea= Intent(this@MainActivity, UnhappyActivity::class.java)
            startActivity(tembea)
        }

        mSad.setOnClickListener {
            val tembea= Intent(this@MainActivity, SadActivity::class.java)
            startActivity(tembea)
        }
        mAddArticle.setOnClickListener {
            val tembea= Intent(this@MainActivity, AddarticlesActivity::class.java)
            startActivity(tembea)
        }

        mHelpline.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0780799142"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        mHotline.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0780799142"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
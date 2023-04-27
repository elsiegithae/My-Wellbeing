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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHappy=findViewById(R.id.btnHappy)
        mAngry=findViewById(R.id.btnAngry)
        mRad=findViewById(R.id.btnRad)
        mSad=findViewById(R.id.btnSad)
        mUnhappy=findViewById(R.id.btnUnhappy)
        mHotline=findViewById(R.id.btnHotline)



        mHappy.setOnClickListener {
            val tembea= Intent(this@MainActivity, happy::class.java)
            startActivity(tembea)
        }

        mAngry.setOnClickListener {
            val tembea= Intent(this@MainActivity, angry::class.java)
            startActivity(tembea)
        }

        mRad.setOnClickListener {
            val tembea= Intent(this@MainActivity, rad::class.java)
            startActivity(tembea)
        }

        mUnhappy.setOnClickListener {
            val tembea= Intent(this@MainActivity, unhappy::class.java)
            startActivity(tembea)
        }

        mSad.setOnClickListener {
            val tembea= Intent(this@MainActivity, sad::class.java)
            startActivity(tembea)
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
                        arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    startActivity(intent)
                }
            }







    }
}
package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    lateinit var btnRegister:Button
    lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnRegister=findViewById(R.id.mBtnReg)
        btnLogin=findViewById(R.id.mBtnLogin)

        btnLogin.setOnClickListener {
            var tembea= Intent(this, LoginActivity::class.java)
            startActivity(tembea)
        }
        btnRegister.setOnClickListener {
            var tembea= Intent(this, RegisterActivity::class.java)
            startActivity(tembea)
        }

    }
}
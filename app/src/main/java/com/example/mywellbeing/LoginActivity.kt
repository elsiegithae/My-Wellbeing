package com.example.mywellbeing

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var edtName: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtName=findViewById(R.id.txtName)
        edtPassword=findViewById(R.id.txtPass)
        btnLogin=findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            var tembea= Intent(this, MainActivity ::class.java)
            startActivity(tembea)
        }
    }
}
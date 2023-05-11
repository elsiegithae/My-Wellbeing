package com.example.mywellbeing

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogin: Button
    private lateinit var mTvLogin: TextView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var progress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtEmail=findViewById(R.id.txtName)
        edtPassword=findViewById(R.id.txtPass)
        btnLogin=findViewById(R.id.btnLogin)
        mTvLogin = findViewById(R.id.mTvLogin)
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()
        mTvLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            progress.show()
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this,"User logged in successfully!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    finish()
                }
            }
        }

        btnLogin.setOnClickListener {
            var tembea= Intent(this, MainActivity ::class.java)
            startActivity(tembea)
        }
    }
}
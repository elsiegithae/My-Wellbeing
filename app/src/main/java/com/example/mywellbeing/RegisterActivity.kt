package com.example.mywellbeing

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class
RegisterActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var btnRegister: Button
    private lateinit var edtFullName: EditText
    private lateinit var edtUserName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var mTvLogin: TextView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var progress:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister = findViewById(R.id.btnRegister)
        edtFullName = findViewById(R.id.txtNameFull)
        edtUserName = findViewById(R.id.txtUsername)
        edtEmail = findViewById(R.id.txtemail)
        edtPassword = findViewById(R.id.txtpword)
        mTvLogin = findViewById(R.id.mTvLogin)
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()
        mTvLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        btnRegister.setOnClickListener{
            val fullName = edtFullName.text.toString()
            val userName = edtUserName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(fullName, userName, email, password)
            progress.show()
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                database.child(userName).setValue(User).addOnSuccessListener {


                    edtFullName.text.clear()
                    edtUserName.text.clear()
                    edtEmail.text.clear()
                    edtPassword.text.clear()

                    Toast.makeText(this,"User registered successfully!", Toast.LENGTH_SHORT).show()
                    mAuth.signOut()
                    startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                    finish()
                }.addOnFailureListener{
                    Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }
}
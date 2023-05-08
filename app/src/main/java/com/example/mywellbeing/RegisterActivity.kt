package com.example.mywellbeing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference

class
RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            val fullName = binding.fullName.text.toString()
            val userName = binding.userName.text.tostring()
            val email = binding.email.text.tostring()
            val password = binding.password.text.tostring()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(fullName, userName, email, password)
            database.child(userName).setValue(User).addOnSuccessListener {

                binding.fullName.text.clear()
                binding.userName.text.clear()
                binding.email.text.clear()
                binding.password.text.clear()

                Toast.makeText(this,"Successfully saved!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
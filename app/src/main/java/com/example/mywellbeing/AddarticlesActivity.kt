package com.example.mywellbeing

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class AddarticlesActivity : AppCompatActivity() {
    lateinit var edtTitle: EditText
    lateinit var edtArticle: EditText
    lateinit var progressDialog: ProgressDialog
    lateinit var btnSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addarticles)
        edtTitle = findViewById(R.id.mEdtArticleTitle)
        edtArticle = findViewById(R.id.mEdtContent)
        btnSave = findViewById(R.id.mBtnSave)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please wait...")

        var receivedTitle = intent.getStringExtra("title")
        var receivedArticle = intent.getStringExtra("article")

        edtTitle.setText(receivedTitle)
        edtArticle.setText(receivedArticle)

        btnSave.setOnClickListener {
            var title = edtTitle.text.toString().trim()
            var article = edtArticle.text.toString().trim()
            if (title.isEmpty()) {
                edtTitle.setError("Please fill in this field")
                edtTitle.requestFocus()
            } else if (article.isEmpty()) {
                edtArticle.setError("Please fill in this field")
                edtArticle.requestFocus()
            }else {
                //proceed to save
                var user = AddArticles(title, article!!)
                // Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().getReference().child("Addarticles/" )
                //Show the progress to start saving
                ref.setValue(user).addOnCompleteListener {
                    // Dismiss the progress and check if the task is successful
                        task ->
                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "Article updated sucessfully",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(this@AddarticlesActivity,MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this, "Article updating failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }
    }
}
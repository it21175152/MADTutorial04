package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val edtName: EditText = binding.editTextTextPersonName
        val edtEmail:EditText = binding.editTextTextPersonName2
        val edtPhone:EditText = binding.editTextTextPersonName3
        val edtPassword:EditText = binding.editTextTextPersonName4
        val edtRePassword:EditText = binding.editTextTextPersonName5
        val btnSubmit: Button = binding.button
        val btnCancel:Button = binding.button2

        btnSubmit.setOnClickListener {
            showAlertBox(
                this,
                edtName.text.toString(),
                edtEmail.text.toString(),
                edtPhone.text.toString(),
                edtPassword.text.toString(),
                edtRePassword.text.toString()
            )
        }
    }

    fun showAlertBox(
        context: Context,
        name: String,
        email: String,
        phone: String,
        password: String,
        rePassword: String
    ) {
        val builder = AlertDialog.Builder(context)
        val message = "Email: $email\n" +
                "Phone: $phone\n" +
                "Passwords: ${if (password == rePassword) "Matching" else "NotMatching"}."
        builder.setTitle("Welcome $name!")
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { _, _ ->
            Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Cancel"){_, _ ->
        }
        val dialog = builder.create()
        dialog.show()
}}
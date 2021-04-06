package com.example.wdcinema.common

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.wdcinema.R
import com.example.wdcinema.api.wdapi
import com.example.wdcinema.databinding.ActivitySignUpBinding
import org.json.JSONObject

class SignUpActivity : AppCompatActivity() {
    lateinit var requestQueue: RequestQueue
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        requestQueue = Volley.newRequestQueue(this)


        binding.registrate.setOnClickListener {
            val firsrName = binding.firstName.text.toString()
            val lastName = binding.LastName.text.toString()
            val email = binding.email.text.toString()
            val register_pass = binding.passwordUp.text.toString()
            if (firsrName.isEmpty() || lastName.isEmpty() || email.isEmpty() || register_pass.isEmpty()) {
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()


                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Не правильный Email", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener }

                 val i = Intent(this,MainActivity::class.java)
                startActivity(i)
            }
        }
        binding.haveaccount.setOnClickListener{
            val i = Intent(this,SignIn::class.java)
            startActivity(i)

            finish()
        }
    }
}
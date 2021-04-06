package com.example.wdcinema.common

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.wdcinema.R

class SplashActivity : AppCompatActivity() {
    private val TIME: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Splash()
    }

   private fun Splash() {
        Handler().postDelayed({  val i = Intent(this, SignIn::class.java)
            startActivity(i)
            finish()},TIME)



        }

    }


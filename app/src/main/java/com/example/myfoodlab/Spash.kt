package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Spash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)


        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this, WelcomeSignup::class.java)
                startActivity(intent)
            }, 3000)
        }
    }
}
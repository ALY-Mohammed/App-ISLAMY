package com.example.islamy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(object :Runnable{
            override fun run() {
               var intentHone =Intent(this@SplashActivity,HomeActivity::class.java)
                startActivity(intentHone)
            }
        },1000)
    }
}
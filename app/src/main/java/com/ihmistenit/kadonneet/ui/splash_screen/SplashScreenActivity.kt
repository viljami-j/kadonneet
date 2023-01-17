package com.ihmistenit.kadonneet.ui.splash_screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ihmistenit.kadonneet.MainActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java)) // ItemDetailHostActivity = MainActivity
        finish()
    }
}
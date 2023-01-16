package com.ihmistenit.kadonneet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UserAdvertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_advert)

        val b: Bundle? = intent.extras
        val id: Int = b?.getInt("id") ?: -1
        if (id == -1) print("UserAdvertActivity: Failed to find an advert with provided id")
    }
}
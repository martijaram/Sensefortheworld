package com.example.sense

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class LauncherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        goToHome()
    }

    fun goToHome() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@LauncherActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }
}

package com.example.buyandsell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    var timer: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@MainActivity, Login::class.java)
                startActivity(intent)
                finish()
            }
        }, 5000)
    }
}


package com.macinjoke.hakarukintore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    var timerText: TextView? = null
    var count: Int = 0;
    private var timer = Timer()
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerText = findViewById(R.id.timer_text)
    }

    fun start(view: View) {
        println("start が押された")
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                count++;
                handler.post(Runnable {
                    timerText!!.text = "カウント: $count"
                })
            }
        }, 0, 1000)
    }

    fun stop(view: View) {
        println("cancel が押された")
        timer.cancel()
        timer = Timer()
    }
}

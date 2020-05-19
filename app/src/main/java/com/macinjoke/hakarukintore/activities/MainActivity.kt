package com.macinjoke.hakarukintore.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import com.macinjoke.hakarukintore.R
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    var timerText: TextView? = null
    var count: Int = 70;
    private var timer = Timer()
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerText = findViewById(R.id.timer_text)
    }

    private fun toTimerString(num: Int): String {
        val minutes = String.format("%02d", num / 60)
        val seconds = String.format("%02d", num % 60)
        return "${minutes}:${seconds}"
    }

    fun start(view: View) {
        println("start が押された")
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (count > 0) {
                    count--;
                    handler.post(Runnable {
                        timerText!!.text = toTimerString(count)
                    })
                } else {
                    println("count が0になった")
                }
            }
        }, 0, 1000)
    }

    fun stop(view: View) {
        println("cancel が押された")
        timer.cancel()
        timer = Timer()
    }

    fun moveToScheduleList(view: View) {
        println("スケジュールリストへ移動ボタンが押された")
        val intent = Intent(this, ScheduleListActivity::class.java)
        startActivity(intent)
    }
}

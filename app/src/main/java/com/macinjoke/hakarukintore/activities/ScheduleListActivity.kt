package com.macinjoke.hakarukintore.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import com.macinjoke.hakarukintore.R
import com.macinjoke.hakarukintore.fragments.TimeSettingFragment
import com.macinjoke.hakarukintore.utils.Utils


// スケジュールのリストを表示するアクティビティ
class ScheduleListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_list)
        updateTimer()
    }

    private fun updateTimer() {
        val sharedPref = getSharedPreferences("timer", Context.MODE_PRIVATE)
        val timerSec = sharedPref.getInt("timer_sec", 30)

        val timerString = Utils.toTimerString(timerSec)

        val map1 = HashMap<String, String>()
        map1["no"] = "01"
        map1["name"] = timerString
        val map2 = HashMap<String, String>()
        map2["no"] = "02"
        map2["name"] = "ふがちゃん"
        val listData = ArrayList<Map<String, String>>()
        listData.add(map1)
        listData.add(map2)

        val adapter = SimpleAdapter(
            this,
            listData,
            R.layout.timer_list_item,
            arrayOf("no", "name"),
            intArrayOf(R.id.no, R.id.name)
        )
        val listView = findViewById<ListView>(R.id.timer_list)
        listView.adapter = adapter
    }

    fun createSchedule(view: View) {
        println("新しいスケジュールを作成ボタンを押した")

        // TODO ほんとはこんな感じにコールバックを渡したい
//        val dialog = TimeSettingFragment(updateTimer)
        val dialog = TimeSettingFragment()
        dialog.show(supportFragmentManager, "aiueo") // tagってなんだろ
    }

    fun onClickTimer(view: View) {
        println("timer がおされた")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


//    fun moveToNewSchedule(view: View) {
//        val intent = Intent(this, NewScheduleActivity::class.java)
//        startActivity(intent)
//    }

}

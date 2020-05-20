package com.macinjoke.hakarukintore.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.macinjoke.hakarukintore.R
import com.macinjoke.hakarukintore.fragments.BlankFragment
import com.macinjoke.hakarukintore.fragments.TimeSettingFragment

// スケジュールのリストを表示するアクティビティ
class ScheduleListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_list)
    }

    fun createSchedule(view: View) {
        println("新しいスケジュールを作成ボタンを押した")

//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.container, BlankFragment())
//        transaction.commit()

        val dialog = TimeSettingFragment()
        dialog.show(supportFragmentManager, "aiueo") // tagってなんだろ
    }


//    fun moveToNewSchedule(view: View) {
//        val intent = Intent(this, NewScheduleActivity::class.java)
//        startActivity(intent)
//    }

}

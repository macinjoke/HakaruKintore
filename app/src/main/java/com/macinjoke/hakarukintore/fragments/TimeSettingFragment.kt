package com.macinjoke.hakarukintore.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.macinjoke.hakarukintore.R


// 時間を設定するダイアログのフラグメント
class TimeSettingFragment() : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.time_setting, null, false)
        val sharedPref = activity!!.getSharedPreferences("timer", Context.MODE_PRIVATE)
        val timerSec = sharedPref.getInt("timer_sec", 30)
        println(timerSec)

        val m1np = view.findViewById<NumberPicker>(R.id.minutes1numberPicker)
        m1np.minValue = 0
        m1np.maxValue = 9
        m1np.value = timerSec / 600

        val m2np = view.findViewById<NumberPicker>(R.id.minutes2numberPicker)
        m2np.minValue = 0
        m2np.maxValue = 9
        m2np.value = timerSec % 600 / 60

        val s1np = view.findViewById<NumberPicker>(R.id.seconds1numberPicker)
        s1np.minValue = 0
        s1np.maxValue = 5
        s1np.value = timerSec % 60 / 10

        val s2np = view.findViewById<NumberPicker>(R.id.seconds2numberPicker)
        s2np.minValue = 0
        s2np.maxValue = 9
        s2np.value = timerSec % 10

        val builder =
            AlertDialog.Builder(activity)
        builder.setTitle("タイマー")
        val filename = "myfile"
        builder.setPositiveButton(
            "OK"
        ) { dialog, which ->
            val seconds = m1np.value * 600 + m2np.value * 60 + s1np.value * 10 + s2np.value
            println(seconds)
            with(sharedPref.edit()) {
                this?.putInt("timer_sec", seconds)
                this?.apply()
            }
            // TODO ここで本当はScheduleListActivity のviewの更新がしたい
        }
        println(timerSec)

        builder.setNegativeButton("Cancel", null)
        builder.setView(view)
        return builder.create()
    }
}
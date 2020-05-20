package com.macinjoke.hakarukintore.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.macinjoke.hakarukintore.R


// 時間を設定するダイアログのフラグメント
class TimeSettingFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.time_setting, null, false)

        val m1np = view.findViewById<NumberPicker>(R.id.minutes1numberPicker)
        m1np.minValue = 0
        m1np.maxValue = 9
        m1np.value = 0

        val m2np = view.findViewById<NumberPicker>(R.id.minutes2numberPicker)
        m2np.minValue = 0
        m2np.maxValue = 9
        m2np.value = 1

        val s1np = view.findViewById<NumberPicker>(R.id.seconds1numberPicker)
        s1np.minValue = 0
        s1np.maxValue = 5
        s1np.value = 0

        val s2np = view.findViewById<NumberPicker>(R.id.seconds2numberPicker)
        s2np.minValue = 0
        s2np.maxValue = 9
        s2np.value = 0

        val builder =
            AlertDialog.Builder(activity)
        builder.setTitle("タイマー")
        builder.setPositiveButton(
            "OK"
        ) { dialog, which ->
            // TODO OKクリック時の処理
            println(m1np.value)
            println(m2np.value)
        }
        builder.setNegativeButton("Cancel", null)
        builder.setView(view)
        return builder.create()
    }
}
package com.macinjoke.hakarukintore.utils

class Utils {
    companion object {
        fun toTimerString(sec: Int): String {
            val minutes = String.format("%02d", sec / 60)
            val seconds = String.format("%02d", sec % 60)
            return "${minutes}:${seconds}"
        }
    }
}
package com.example.countdowntimerjc.utils

import java.util.concurrent.TimeUnit

object Utility {

    const val TAG = "Timer"

    private const val TIME_FORMAT = "%02d:%02d"

    const val POMODORO_COUNTDOWN: Long = 1500000L
    const val LONG_PAUSE_COUNTDOWN: Long = 900000L
    const val SHORT_PAUSE_COUNTDOWN: Long = 300000L


    //convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

}

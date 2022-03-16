package com.example.countdowntimerjc.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countdowntimerjc.utils.Utility.TAG
import com.example.countdowntimerjc.utils.Utility.formatTime


class PomodoroViewModel : ViewModel() {

    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableLiveData<String>()
    val time: LiveData<String> = _time

    private val _isStarted = MutableLiveData<Boolean>()
    val isStarted: LiveData<Boolean> = _isStarted

    fun startTimer(timeToCount: Long) {
        _isStarted.value = false
        countDownTimer = object : CountDownTimer(timeToCount, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _time.value = millisUntilFinished.formatTime()
                Log.d(TAG, "Time -> ${time.value}")
            }

            override fun onFinish() {
                Log.d(TAG, "Time -> Finished")
            }
        }.start()
    }

    fun stopTimer() {
        Log.d(TAG, "Time -> Canceled")
        countDownTimer?.cancel()
        _time.value = "Set timer"
        _isStarted.value = true
    }


}



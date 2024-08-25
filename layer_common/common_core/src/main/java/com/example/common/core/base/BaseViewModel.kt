package com.example.common.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.core.event.SingleLiveEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author: cb
 * @date: 2023/7/20
 * @desc: 描述
 */
open class BaseViewModel : ViewModel() {

    private var finishJob: Job? = null
    val finishEvent by lazy(LazyThreadSafetyMode.NONE) { SingleLiveEvent<Boolean>() }


    fun delayFinish(time: Long) {
        finishJob?.cancel()
        finishJob = viewModelScope.launch {
            delay(time)
            finish()
        }
    }

    fun finish() {
        finishEvent.value = true
    }
}
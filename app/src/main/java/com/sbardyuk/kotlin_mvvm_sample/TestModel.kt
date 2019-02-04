package com.sbardyuk.kotlin_mvvm_sample

import android.os.Handler

class TestModel {
    fun refreshData(onDataReadyCallback : OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new data") },2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data : String)
}
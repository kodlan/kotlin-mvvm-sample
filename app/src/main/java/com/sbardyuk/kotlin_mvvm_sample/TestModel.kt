package com.sbardyuk.kotlin_mvvm_sample

import android.os.Handler

class TestModel {
    fun refreshData(onDataReadyCallback : OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new data") },2000)
    }

    fun getListData(onListDataReadyCallback: OnListDataReadyCallback) {
        val list = arrayListOf(
            ListItem("test1", "test2"),
            ListItem("test3", "test4"),
            ListItem("test5", "test6"))
        Handler().postDelayed({ onListDataReadyCallback.onDataReady(list)}, 2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data : String)
}

interface OnListDataReadyCallback {
    fun onDataReady(data: List<ListItem>)
}

data class ListItem(val value1: String, val value2: String)
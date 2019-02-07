package com.sbardyuk.kotlin_mvvm_sample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class TestViewModel : ViewModel() {
    var testModel = TestModel ()

    var text = ObservableField<String> ()
    var listLiveData = MutableLiveData<ArrayList<ListItem>>()

    var isLoading = ObservableField<Boolean> ()

    fun refresh() {
        isLoading.set(true)

        testModel.refreshData( object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                text.set(data)
                isLoading.set(false)
            }
        })
    }

    fun loadListData() {
        isLoading.set(true)

        testModel.getListData(object : OnListDataReadyCallback {
            override fun onDataReady(data: List<ListItem>) {
                isLoading.set(false)
                listLiveData.value = ArrayList(data)
            }
        })
    }
}
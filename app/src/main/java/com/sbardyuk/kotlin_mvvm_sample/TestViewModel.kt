package com.sbardyuk.kotlin_mvvm_sample

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class TestViewModel : ViewModel() {
    var repoModel = TestModel ()
    var text = ObservableField<String> ()
    var isLoading = ObservableField<Boolean> ()

    fun refresh() {
        isLoading.set(true)

        repoModel.refreshData( object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                text.set(data)
                isLoading.set(false)
            }
        })
    }
}
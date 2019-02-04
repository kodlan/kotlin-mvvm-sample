package com.sbardyuk.kotlin_mvvm_sample

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sbardyuk.kotlin_mvvm_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        binding.executePendingBindings()
    }
}

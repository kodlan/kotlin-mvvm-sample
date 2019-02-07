package com.sbardyuk.kotlin_mvvm_sample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sbardyuk.kotlin_mvvm_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TestRecyclerViewAdapter.OnItemClickListener {

    private val repositoryRecyclerViewAdapter = TestRecyclerViewAdapter(arrayListOf(), this)

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.listItems.layoutManager = LinearLayoutManager(this)
        binding.listItems.adapter = repositoryRecyclerViewAdapter
        viewModel.listLiveData.observe(this,
            Observer<ArrayList<ListItem>> { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })

    }

    override fun onItemClick(position: Int) {

    }
}

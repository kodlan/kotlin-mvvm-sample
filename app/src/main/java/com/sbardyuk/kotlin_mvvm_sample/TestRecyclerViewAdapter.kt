package com.sbardyuk.kotlin_mvvm_sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sbardyuk.kotlin_mvvm_sample.databinding.ItemLayoutBinding

class TestRecyclerViewAdapter(private var items: List<ListItem>,
                                    private var listener: OnItemClickListener)
    : RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = com.sbardyuk.kotlin_mvvm_sample.databinding.ItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    fun replaceData(newData : ArrayList<ListItem>) {
        this.items = newData
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListItem, listener: OnItemClickListener?) {
            binding.listItem = item

            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }

}
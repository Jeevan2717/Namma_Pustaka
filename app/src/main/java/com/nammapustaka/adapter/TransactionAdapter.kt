package com.nammapustaka.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nammapustaka.R
import com.nammapustaka.data.dao.TransactionDetail
import com.nammapustaka.databinding.ItemTransactionBinding
import com.nammapustaka.util.DateUtil

class TransactionAdapter(private val showStudent: Boolean = true, private val onReturn: ((TransactionDetail) -> Unit)? = null) : RecyclerView.Adapter<TransactionAdapter.Holder>() {
    private val items = mutableListOf<TransactionDetail>()
    fun submit(list: List<TransactionDetail>) { items.clear(); items.addAll(list); notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(items[position])
    inner class Holder(private val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TransactionDetail) {
            binding.titleText.text = item.bookTitle
            binding.subtitleText.text = if (showStudent) item.studentName else item.author
            binding.dateText.text = "Issued: ${DateUtil.format(item.issueDate)} · Due: ${DateUtil.format(item.dueDate)}"
            binding.statusText.text = when {
                item.isReturned -> "Returned"
                item.isOverdue -> "OVERDUE"
                else -> "Active"
            }
            if (item.isOverdue) {
                binding.root.setBackgroundColor(binding.root.context.getColor(R.color.colorOverdueBg))
                binding.dateText.setTextColor(binding.root.context.getColor(R.color.colorOverdue))
                binding.statusText.setTextColor(binding.root.context.getColor(R.color.colorOverdue))
            } else {
                binding.root.setBackgroundColor(Color.TRANSPARENT)
                binding.dateText.setTextColor(Color.DKGRAY)
                binding.statusText.setTextColor(Color.DKGRAY)
            }
            binding.root.setOnClickListener { onReturn?.invoke(item) }
        }
    }
}

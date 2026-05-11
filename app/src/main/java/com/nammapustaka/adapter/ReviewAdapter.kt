package com.nammapustaka.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nammapustaka.data.dao.ReviewDetail
import com.nammapustaka.databinding.ItemReviewBinding
import com.nammapustaka.util.DateUtil

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.Holder>() {
    private val items = mutableListOf<ReviewDetail>()
    fun submit(list: List<ReviewDetail>) { items.clear(); items.addAll(list); notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(items[position])
    class Holder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReviewDetail) {
            binding.nameText.text = item.studentName
            binding.ratingBar.rating = item.starRating.toFloat()
            binding.reviewText.text = item.reviewText
            binding.dateText.text = DateUtil.format(item.reviewDate)
        }
    }
}

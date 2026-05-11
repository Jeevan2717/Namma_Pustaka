package com.nammapustaka.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nammapustaka.R
import com.nammapustaka.data.entity.StudentEntity
import com.nammapustaka.databinding.ItemLeaderboardBinding

class LeaderboardAdapter : RecyclerView.Adapter<LeaderboardAdapter.Holder>() {
    private val items = mutableListOf<StudentEntity>()
    fun submit(list: List<StudentEntity>) { items.clear(); items.addAll(list); notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemLeaderboardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(items[position], position + 1)
    class Holder(private val binding: ItemLeaderboardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: StudentEntity, rank: Int) {
            binding.rankText.text = "#$rank"
            binding.rankText.setTextColor(Color.parseColor(when (rank) { 1 -> "#EF9F27"; 2 -> "#B4B2A9"; 3 -> "#D85A30"; else -> "#777777" }))
            binding.nameText.text = student.name
            binding.classText.text = student.classSection
            binding.pagesText.text = "${student.totalPagesRead} pages"
            Glide.with(binding.avatarImage.context).load(student.avatarPath).placeholder(R.drawable.ic_person).into(binding.avatarImage)
        }
    }
}

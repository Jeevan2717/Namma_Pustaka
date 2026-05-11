package com.nammapustaka.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nammapustaka.R
import com.nammapustaka.data.entity.StudentEntity
import com.nammapustaka.databinding.ItemStudentBinding

class StudentListAdapter(private val onClick: (Int) -> Unit) : RecyclerView.Adapter<StudentListAdapter.Holder>() {
    private val items = mutableListOf<StudentEntity>()
    fun submit(list: List<StudentEntity>) { items.clear(); items.addAll(list); notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(items[position])
    inner class Holder(private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: StudentEntity) {
            binding.nameText.text = student.name
            binding.metaText.text = "Roll ${student.rollNumber} · ${student.classSection}"
            binding.borrowChip.text = "0 books borrowed"
            binding.pagesText.text = "${student.totalPagesRead} pages read"
            Glide.with(binding.avatarImage.context).load(student.avatarPath).placeholder(R.drawable.ic_person).into(binding.avatarImage)
            binding.root.setOnClickListener { onClick(student.id) }
        }
    }
}

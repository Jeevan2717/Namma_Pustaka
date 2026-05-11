package com.nammapustaka.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nammapustaka.R
import com.nammapustaka.data.dao.BookBorrowInfo
import com.nammapustaka.databinding.ItemBookGridBinding
import com.nammapustaka.util.DateUtil

class BookGridAdapter(private val role: String, private val onClick: (Int) -> Unit) : RecyclerView.Adapter<BookGridAdapter.Holder>() {
    private val items = mutableListOf<BookBorrowInfo>()

    fun submit(list: List<BookBorrowInfo>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(ItemBookGridBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(items[position])

    inner class Holder(private val binding: ItemBookGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: BookBorrowInfo) {
            binding.titleText.text = book.title
            binding.authorText.text = book.author
            binding.ratingBar.rating = 4.0f
            Glide.with(binding.coverImage.context).load(book.coverImagePath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
            val available = book.isAvailable
            binding.statusBadge.text = if (available) "Available" else "Borrowed"
            binding.statusBadge.setTextColor(Color.parseColor(if (available) "#085041" else "#633806"))
            binding.statusBadge.background = pill(if (available) "#E1F5EE" else "#FAEEDA")
            val showBorrower = role == "teacher" && !available
            binding.borrowerText.visibility = if (showBorrower) View.VISIBLE else View.GONE
            binding.sinceText.visibility = if (showBorrower) View.VISIBLE else View.GONE
            binding.borrowerText.text = "By: ${book.studentName.orEmpty()}"
            binding.sinceText.text = book.issueDate?.let { "Since: ${DateUtil.format(it)}" } ?: ""
            binding.root.setOnClickListener { onClick(book.id) }
        }
    }

    private fun pill(color: String) = GradientDrawable().apply {
        setColor(Color.parseColor(color))
        cornerRadius = 32f
    }
}

package com.nammapustaka.ui.scan

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.NammaPustakaApp
import com.nammapustaka.R
import com.nammapustaka.databinding.DialogReturnBookBinding
import com.nammapustaka.util.DateUtil
import kotlinx.coroutines.launch

class ReturnBookDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogReturnBookBinding.inflate(layoutInflater)
        val bookId = arguments?.getInt("bookId") ?: 0
        val app = requireActivity().application as NammaPustakaApp
        lifecycleScope.launch {
            val book = app.bookRepository.bookOnce(bookId) ?: return@launch
            val tx = app.transactionRepository.activeForBookOnce(bookId) ?: return@launch
            val student = app.studentRepository.studentOnce(tx.studentId)
            binding.titleText.text = book.title
            binding.detailText.text = "Currently borrowed by: ${student?.name.orEmpty()}\nIssued on: ${DateUtil.format(tx.issueDate)}\nDue: ${DateUtil.format(tx.dueDate)}"
            if (tx.isOverdue) binding.detailText.setTextColor(requireContext().getColor(R.color.colorOverdue))
            Glide.with(this@ReturnBookDialog).load(book.coverImagePath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
            binding.confirmButton.setOnClickListener {
                lifecycleScope.launch {
                    app.transactionRepository.returnBook(tx, book.totalPages)
                    Snackbar.make(requireActivity().findViewById(android.R.id.content), "Book returned by ${student?.name.orEmpty()}", Snackbar.LENGTH_SHORT).show()
                    dismiss()
                }
            }
        }
        return AlertDialog.Builder(requireContext()).setView(binding.root).create()
    }

    companion object {
        fun newInstance(bookId: Int) = ReturnBookDialog().apply { arguments = Bundle().apply { putInt("bookId", bookId) } }
    }
}

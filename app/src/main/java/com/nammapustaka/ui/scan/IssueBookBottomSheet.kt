package com.nammapustaka.ui.scan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.NammaPustakaApp
import com.nammapustaka.R
import com.nammapustaka.databinding.BottomSheetIssueBookBinding
import com.nammapustaka.util.DateUtil
import com.nammapustaka.util.SessionManager

class IssueBookBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetIssueBookBinding
    private val vm: ScanViewModel by viewModels()
    private var selectedStudentId = 0
    private var dueDate = DateUtil.dueDate()
    private val bookId get() = arguments?.getInt("bookId") ?: 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = BottomSheetIssueBookBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val app = requireActivity().application as NammaPustakaApp
        binding.issueDateText.text = "Issue Date: ${DateUtil.format(System.currentTimeMillis())}"
        binding.dueDateButton.text = "Due Date: ${DateUtil.format(dueDate)}"
        vm.students.observe(viewLifecycleOwner) { students ->
            binding.studentInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, students.map { "${it.name} (${it.rollNumber})" }))
            binding.studentInput.setOnItemClickListener { _, _, pos, _ -> selectedStudentId = students[pos].id }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            app.bookRepository.bookOnce(bookId)?.let {
                binding.titleText.text = it.title
                Glide.with(this@IssueBookBottomSheet).load(it.coverImagePath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
            }
        }
        binding.confirmButton.setOnClickListener {
            if (selectedStudentId == 0) {
                binding.studentLayout.error = "Select student"
            } else {
                vm.issue(bookId, selectedStudentId, SessionManager(requireContext()).getUserId(), System.currentTimeMillis(), dueDate) {
                    Snackbar.make(requireActivity().findViewById(android.R.id.content), "Book issued", Snackbar.LENGTH_SHORT).show()
                    dismiss()
                }
            }
        }
        binding.cancelButton.setOnClickListener { dismiss() }
    }

    companion object {
        fun newInstance(bookId: Int) = IssueBookBottomSheet().apply { arguments = Bundle().apply { putInt("bookId", bookId) } }
    }
}

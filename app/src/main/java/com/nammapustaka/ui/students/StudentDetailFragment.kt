package com.nammapustaka.ui.students

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nammapustaka.R
import com.nammapustaka.adapter.TransactionAdapter
import com.nammapustaka.databinding.FragmentStudentDetailBinding
import com.nammapustaka.ui.requireTeacherOrHome

class StudentDetailFragment : Fragment(R.layout.fragment_student_detail) {
    private lateinit var binding: FragmentStudentDetailBinding
    private val vm: StudentViewModel by viewModels()
    private val studentId get() = arguments?.getInt("studentId") ?: 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentStudentDetailBinding.bind(view)
        if (!requireTeacherOrHome()) return
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        val current = TransactionAdapter(showStudent = false)
        val history = TransactionAdapter(showStudent = false)
        binding.currentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.currentRecyclerView.adapter = current
        binding.historyRecyclerView.adapter = history
        vm.student(studentId).observe(viewLifecycleOwner) {
            if (it != null) {
                binding.nameText.text = it.name
                binding.metaText.text = "Roll ${it.rollNumber} · ${it.classSection}"
                Glide.with(this).load(it.avatarPath).placeholder(R.drawable.ic_person).into(binding.avatarImage)
            }
        }
        vm.transactions(studentId).observe(viewLifecycleOwner) { tx ->
            current.submit(tx.filter { !it.isReturned })
            history.submit(tx.filter { it.isReturned })
            binding.emptyView.visibility = if (tx.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}

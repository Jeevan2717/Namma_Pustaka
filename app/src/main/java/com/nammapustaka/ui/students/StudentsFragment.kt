package com.nammapustaka.ui.students

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammapustaka.R
import com.nammapustaka.adapter.StudentListAdapter
import com.nammapustaka.databinding.FragmentStudentsBinding
import com.nammapustaka.ui.requireTeacherOrHome

class StudentsFragment : Fragment(R.layout.fragment_students) {
    private lateinit var binding: FragmentStudentsBinding
    private val vm: StudentViewModel by viewModels()
    private lateinit var adapter: StudentListAdapter
    private var all = listOf<com.nammapustaka.data.entity.StudentEntity>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentStudentsBinding.bind(view)
        if (!requireTeacherOrHome()) return
        adapter = StudentListAdapter { findNavController().navigate(R.id.studentDetailFragment, Bundle().apply { putInt("studentId", it) }) }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener { findNavController().navigate(R.id.action_students_to_addStudent) }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = true
            override fun onQueryTextChange(newText: String?): Boolean { filter(newText.orEmpty()); return true }
        })
        vm.students.observe(viewLifecycleOwner) { all = it; filter("") }
    }

    private fun filter(query: String) {
        val list = all.filter { query.isBlank() || it.name.contains(query, true) || it.rollNumber.contains(query, true) }
        adapter.submit(list)
        binding.emptyView.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
    }
}

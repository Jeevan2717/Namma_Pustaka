package com.nammapustaka.ui.reports

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammapustaka.R
import com.nammapustaka.adapter.TransactionAdapter
import com.nammapustaka.databinding.FragmentReportsBinding
import com.nammapustaka.ui.requireTeacherOrHome

class ReportsFragment : Fragment(R.layout.fragment_reports) {
    private lateinit var binding: FragmentReportsBinding
    private val vm: ReportsViewModel by viewModels()
    private val adapter = TransactionAdapter(showStudent = true)
    private var summary = "Namma Pustaka report"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentReportsBinding.bind(view)
        if (!requireTeacherOrHome()) return
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.toolbar.inflateMenu(R.menu.reports_menu)
        binding.toolbar.setOnMenuItemClickListener {
            startActivity(Intent.createChooser(Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_TEXT, summary), "Export summary"))
            true
        }
        vm.overdue.observe(viewLifecycleOwner) { list ->
            if (binding.tabLayout.selectedTabPosition == 0) {
                adapter.submit(list)
                binding.emptyView.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            }
            summary = "Namma Pustaka Report\nOverdue: ${list.size}\n" + list.joinToString("\n") { "${it.studentName} - ${it.bookTitle}" }
        }
        vm.history.observe(viewLifecycleOwner) { list ->
            if (binding.tabLayout.selectedTabPosition == 1) {
                adapter.submit(list)
                binding.emptyView.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            } else if (binding.tabLayout.selectedTabPosition == 2) {
                summary = "Total issues: ${list.size}"
                adapter.submit(list.take(5))
                binding.emptyView.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            }
        }
        binding.tabLayout.addOnTabSelectedListener(object : com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: com.google.android.material.tabs.TabLayout.Tab) {
                when (tab.position) {
                    0 -> vm.overdue.value?.let { adapter.submit(it); binding.emptyView.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE }
                    1 -> vm.history.value?.let { adapter.submit(it); binding.emptyView.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE }
                    2 -> vm.history.value?.let { adapter.submit(it.take(5)); binding.emptyView.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE }
                }
            }
            override fun onTabUnselected(tab: com.google.android.material.tabs.TabLayout.Tab) {}
            override fun onTabReselected(tab: com.google.android.material.tabs.TabLayout.Tab) {}
        })
    }
}

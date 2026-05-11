package com.nammapustaka.ui.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nammapustaka.R
import com.nammapustaka.adapter.TransactionAdapter
import com.nammapustaka.databinding.FragmentProfileBinding
import com.nammapustaka.ui.pill
import com.nammapustaka.ui.session

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding
    private val vm: ProfileViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentProfileBinding.bind(view)
        val sm = session()
        val role = sm.getUserRole()
        val currentAdapter = TransactionAdapter(showStudent = false)
        val historyAdapter = TransactionAdapter(showStudent = false)
        binding.currentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.currentRecyclerView.adapter = currentAdapter
        binding.historyRecyclerView.adapter = historyAdapter
        binding.nameText.text = sm.getUserName()
        binding.metaText.text = "Username session #${sm.getUserId()}"
        binding.roleBadge.text = if (role == "teacher") "TEACHER" else "STUDENT"
        binding.roleBadge.pill(requireContext().getColor(if (role == "teacher") R.color.colorTeacherBadge else R.color.colorStudentBadge), android.graphics.Color.WHITE)
        vm.user(sm.getUserId()).observe(viewLifecycleOwner) { user ->
            if (user?.linkedStudentId != null) {
                vm.student(user.linkedStudentId).observe(viewLifecycleOwner) { student ->
                    if (student != null) {
                        binding.nameText.text = student.name
                        binding.metaText.text = "Roll ${student.rollNumber} · ${student.classSection}"
                        Glide.with(this).load(student.avatarPath).placeholder(R.drawable.ic_person).into(binding.avatarImage)
                    }
                }
                vm.studentTransactions(user.linkedStudentId).observe(viewLifecycleOwner) { tx ->
                    currentAdapter.submit(tx.filter { !it.isReturned })
                    historyAdapter.submit(tx.filter { it.isReturned })
                }
            } else {
                binding.borrowedHeader.text = "Library Activity"
                vm.allTransactions.observe(viewLifecycleOwner) { currentAdapter.submit(it.filter { t -> !t.isReturned }); historyAdapter.submit(it.filter { t -> t.isReturned }) }
            }
        }
        addStats(role)
        binding.logoutButton.setOnClickListener {
            AlertDialog.Builder(requireContext()).setTitle("Are you sure you want to logout?").setNegativeButton("Cancel", null).setPositiveButton("Logout") { _, _ ->
                sm.clearSession()
                findNavController().navigate(R.id.action_profile_to_login)
            }.show()
        }
    }

    private fun addStats(role: String) {
        binding.statsGrid.removeAllViews()
        val labels = if (role == "teacher") listOf("Books Added", "Students Managed", "Issues Recorded") else listOf("Books Borrowed", "Pages Read", "Reviews Given")
        labels.forEach { binding.statsGrid.addView(TextView(requireContext()).apply { text = "$it\n0"; gravity = android.view.Gravity.CENTER; layoutParams = android.widget.LinearLayout.LayoutParams(0, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 1f); setPadding(8, 16, 8, 16) }) }
    }
}

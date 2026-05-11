package com.nammapustaka.ui.leaderboard

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammapustaka.R
import com.nammapustaka.adapter.LeaderboardAdapter
import com.nammapustaka.databinding.FragmentLeaderboardBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LeaderboardFragment : Fragment(R.layout.fragment_leaderboard) {
    private lateinit var binding: FragmentLeaderboardBinding
    private val vm: LeaderboardViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLeaderboardBinding.bind(view)
        val adapter = LeaderboardAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.headerText.text = "Reading Leaderboard · ${SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(Date())}"
        vm.students.observe(viewLifecycleOwner) { students ->
            adapter.submit(students)
            binding.podiumLayout.removeAllViews()
            students.take(3).forEachIndexed { index, s -> binding.podiumLayout.addView(TextView(requireContext()).apply { text = "${index + 1}\n${s.name}\n${s.totalPagesRead}"; gravity = android.view.Gravity.CENTER; layoutParams = android.widget.LinearLayout.LayoutParams(0, android.widget.LinearLayout.LayoutParams.MATCH_PARENT, 1f) }) }
            binding.emptyView.visibility = if (students.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}

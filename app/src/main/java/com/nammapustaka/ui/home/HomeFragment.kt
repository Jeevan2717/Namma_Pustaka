package com.nammapustaka.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.adapter.BookGridAdapter
import com.nammapustaka.data.dao.BookBorrowInfo
import com.nammapustaka.databinding.FragmentHomeBinding
import com.nammapustaka.ui.session

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val vm: HomeViewModel by viewModels()
    private lateinit var adapter: BookGridAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)
        val role = session().getUserRole()
        adapter = BookGridAdapter(role) {
            findNavController().navigate(R.id.bookDetailFragment, Bundle().apply { putInt("bookId", it) })
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = adapter
        binding.bottomNav.menu.clear()
        binding.bottomNav.inflateMenu(if (role == "teacher") R.menu.bottom_nav_teacher else R.menu.bottom_nav_student)
        binding.bottomNav.setOnItemSelectedListener {
            if (role == "student" && (it.itemId == R.id.scanFragment || it.itemId == R.id.reportsFragment || it.itemId == R.id.studentsFragment)) {
                Snackbar.make(binding.root, "Teacher access only", Snackbar.LENGTH_SHORT).show()
                true
            } else {
                findNavController().navigate(it.itemId)
                true
            }
        }
        binding.toolbar.setOnMenuItemClickListener {
            findNavController().navigate(if (it.itemId == R.id.action_profile) R.id.action_home_to_profile else R.id.action_home_to_catalog)
            true
        }
        binding.bannerText.text = if (role == "teacher") {
            "Welcome, ${session().getUserName()}!  TEACHER"
        } else {
            "Welcome, ${session().getUserName()}!  STUDENT"
        }
        binding.bannerText.setBackgroundResource(if (role == "teacher") R.drawable.bg_teacher_banner else R.drawable.bg_student_banner)
        addActions(role)
        addChips()
        vm.books.observe(viewLifecycleOwner) { list ->
            adapter.submit(list.take(6))
            binding.emptyView.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            renderStats(role, list)
        }
        vm.overdue.observe(viewLifecycleOwner) { overdue ->
            binding.overdueSection.visibility = if (role == "teacher") View.VISIBLE else View.GONE
            binding.overdueSection.removeAllViews()
            if (role == "teacher" && overdue.isNotEmpty()) {
                binding.overdueSection.addView(sectionTitle("Overdue Alerts"))
            }
            overdue.take(3).forEach {
                binding.overdueSection.addView(TextView(requireContext()).apply {
                    text = "${it.studentName} - ${it.bookTitle}"
                    setTextColor(requireContext().getColor(R.color.colorOverdue))
                    textSize = 15f
                    setPadding(12, 8, 12, 8)
                })
            }
        }
    }

    private fun addActions(role: String) {
        binding.quickActions.removeAllViews()
        val actions = if (role == "teacher") {
            listOf(
                Triple("Add Book", R.id.addBookFragment, R.drawable.ic_book),
                Triple("Scan QR", R.id.scanFragment, R.drawable.ic_camera),
                Triple("Borrow Log", R.id.reportsFragment, R.drawable.ic_empty),
                Triple("Students", R.id.studentsFragment, R.drawable.ic_person),
                Triple("Reports", R.id.reportsFragment, R.drawable.ic_empty)
            )
        } else {
            listOf(
                Triple("Browse Books", R.id.catalogFragment, R.drawable.ic_search),
                Triple("Leaderboard", R.id.leaderboardFragment, R.drawable.ic_trophy),
                Triple("My Profile", R.id.profileFragment, R.drawable.ic_person)
            )
        }
        actions.forEach { (label, dest, iconRes) ->
            binding.quickActions.addView(MaterialButton(requireContext()).apply {
                text = label
                setIconResource(iconRes)
                iconPadding = 12
                iconSize = 64 // Larger icons for low-literacy
                textSize = 16f
                minHeight = 180 
                minWidth = 160
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { setMargins(16) }
                setOnClickListener { findNavController().navigate(dest) }
            })
        }
    }

    private fun addChips() {
        listOf("All", "Story", "Science", "History").forEach {
            binding.categoryChips.addView(Chip(requireContext()).apply {
                text = it
                isCheckable = true
                setChipBackgroundColorResource(R.color.colorSecondaryContainer)
                setTextColor(requireContext().getColor(R.color.colorOnSecondaryContainer))
            })
        }
    }

    private fun renderStats(role: String, books: List<BookBorrowInfo>) {
        binding.statsGrid.removeAllViews()
        val borrowed = books.count { !it.isAvailable }
        val overdue = books.count { it.isOverdue == true }
        val available = books.count { it.isAvailable }
        val stats = if (role == "teacher") {
            listOf("Total Books" to books.size, "Available" to available, "Borrowed" to borrowed, "Overdue" to overdue)
        } else {
            listOf("Total Books" to books.size, "Available" to available, "Borrowed" to borrowed, "Categories" to books.map { it.category }.distinct().size)
        }
        binding.dashboardDetailText.text = if (role == "teacher") {
            "Library snapshot: ${books.size} books, $available available, $borrowed active issues, and $overdue overdue follow-ups. Use Scan QR to issue a physical book to a student profile or record a return."
        } else {
            "Student snapshot: browse ${books.size} books, search by title or author, filter by category, review borrowed books, and track reading progress from Profile."
        }
        stats.forEach { (label, value) ->
            binding.statsGrid.addView(statView(label, value, label == "Overdue"))
        }
    }

    private fun statView(label: String, value: Int, danger: Boolean): TextView {
        return TextView(requireContext()).apply {
            val displayValue = if (value < 10 && value >= 0) "0$value" else "$value"
            text = "$displayValue\n$label"
            gravity = android.view.Gravity.CENTER
            setPadding(16, 24, 16, 24)
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setTextColor(if (danger) requireContext().getColor(R.color.colorOverdue) else requireContext().getColor(R.color.colorOnSurface))
            setBackgroundResource(R.drawable.bg_soft_panel)
            layoutParams = android.widget.GridLayout.LayoutParams().apply {
                width = 0
                height = android.widget.GridLayout.LayoutParams.WRAP_CONTENT
                columnSpec = android.widget.GridLayout.spec(android.widget.GridLayout.UNDEFINED, 1f)
                setMargins(10, 10, 10, 10)
            }
        }
    }

    private fun sectionTitle(textValue: String) = TextView(requireContext()).apply {
        text = textValue
        textSize = 18f
        setTextColor(Color.parseColor("#242234"))
        setPadding(4, 18, 4, 6)
    }
}

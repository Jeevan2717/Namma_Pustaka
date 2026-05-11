package com.nammapustaka.ui.catalog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.adapter.ReviewAdapter
import com.nammapustaka.databinding.FragmentBookDetailBinding
import com.nammapustaka.ui.availability
import com.nammapustaka.ui.categoryKannada
import com.nammapustaka.ui.goneIf
import com.nammapustaka.ui.session
import com.nammapustaka.util.DateUtil
import kotlinx.coroutines.launch

class BookDetailFragment : Fragment(R.layout.fragment_book_detail) {
    private lateinit var binding: FragmentBookDetailBinding
    private val vm: CatalogViewModel by viewModels()
    private val bookId get() = arguments?.getInt("bookId") ?: 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBookDetailBinding.bind(view)
        val role = session().getUserRole()
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.teacherActions.goneIf(role != "teacher")
        binding.borrowDetailsCard.goneIf(role != "teacher")
        binding.addReviewButton.goneIf(role != "student")
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val reviewAdapter = ReviewAdapter()
        binding.recyclerView.adapter = reviewAdapter
        vm.book(bookId).observe(viewLifecycleOwner) { book ->
            if (book == null) return@observe
            binding.titleText.text = book.title
            binding.authorText.text = book.author
            binding.categoryText.text = book.category.categoryKannada()
            binding.summaryText.text = book.summaryKannada.ifBlank { getString(R.string.summary_hint) }
            binding.statusBadge.availability(book.isAvailable, true)
            Glide.with(this).load(book.coverImagePath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
            binding.issueButton.setOnClickListener { IssueLauncher.show(parentFragmentManager, book.id) }
            binding.editButton.setOnClickListener { findNavController().navigate(R.id.editBookFragment, Bundle().apply { putInt("bookId", book.id) }) }
            binding.addReviewButton.setOnClickListener { findNavController().navigate(R.id.action_detail_to_review, Bundle().apply { putInt("bookId", book.id) }) }
            binding.returnButton.setOnClickListener {
                lifecycleScope.launch {
                    val tx = vm.activeForBook(book.id).value
                    Snackbar.make(binding.root, tx?.let { "Use Scan or student detail to return ${book.title}" } ?: "No active borrow", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        vm.activeForBook(bookId).observe(viewLifecycleOwner) { tx ->
            binding.borrowDetailsText.text = if (tx == null) "No one has borrowed this book" else "Issued on: ${DateUtil.format(tx.issueDate)}\nDue on: ${DateUtil.format(tx.dueDate)}${if (tx.isOverdue) "\nOVERDUE" else ""}"
            binding.borrowDetailsText.setTextColor(if (tx?.isOverdue == true) requireContext().getColor(R.color.colorOverdue) else android.graphics.Color.DKGRAY)
        }
        vm.reviews(bookId).observe(viewLifecycleOwner) { reviewAdapter.submit(it); binding.emptyView.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE }
    }
}

object IssueLauncher {
    fun show(manager: androidx.fragment.app.FragmentManager, bookId: Int) {
        com.nammapustaka.ui.scan.IssueBookBottomSheet.newInstance(bookId).show(manager, "issue")
    }
}

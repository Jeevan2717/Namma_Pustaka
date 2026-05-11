package com.nammapustaka.ui.catalog

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.nammapustaka.R
import com.nammapustaka.adapter.BookGridAdapter
import com.nammapustaka.databinding.FragmentCatalogBinding
import com.nammapustaka.ui.session

class CatalogFragment : Fragment(R.layout.fragment_catalog) {
    private lateinit var binding: FragmentCatalogBinding
    private val vm: CatalogViewModel by viewModels()
    private lateinit var adapter: BookGridAdapter
    private var all = listOf<com.nammapustaka.data.dao.BookBorrowInfo>()
    private var query = ""
    private var category = "All"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCatalogBinding.bind(view)
        val role = session().getUserRole()
        adapter = BookGridAdapter(role) { findNavController().navigate(R.id.bookDetailFragment, Bundle().apply { putInt("bookId", it) }) }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
        binding.fab.visibility = if (role == "teacher") View.VISIBLE else View.GONE
        binding.fab.setOnClickListener { findNavController().navigate(R.id.action_catalog_to_addBook) }
        listOf("All", "Story", "Science", "History").forEach { c -> binding.categoryChips.addView(Chip(requireContext()).apply { text = c; isCheckable = true; setOnClickListener { category = c; filter() } }) }
        (binding.categoryChips.getChildAt(0) as Chip).isChecked = true
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(q: String?) = true
            override fun onQueryTextChange(newText: String?): Boolean { query = newText.orEmpty(); filter(); return true }
        })
        vm.books.observe(viewLifecycleOwner) { all = it; filter() }
    }

    private fun filter() {
        val filtered = all.filter { (category == "All" || it.category == category) && (query.isBlank() || it.title.contains(query, true) || it.author.contains(query, true)) }
        adapter.submit(filtered)
        binding.emptyState.visibility = if (filtered.isEmpty()) View.VISIBLE else View.GONE
    }
}

package com.nammapustaka.ui.catalog

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.data.entity.BookEntity
import com.nammapustaka.databinding.FragmentAddBookBinding
import com.nammapustaka.ui.requireTeacherOrHome
import com.nammapustaka.ui.session
import com.nammapustaka.util.ImageUtil

open class AddBookFragment : Fragment(R.layout.fragment_add_book) {
    private lateinit var binding: FragmentAddBookBinding
    private val vm: CatalogViewModel by viewModels()
    private var coverPath = ""
    private val gallery = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            coverPath = ImageUtil.saveImageToInternalStorage(requireContext(), uri)
            Glide.with(this).load(coverPath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
        }
    }

    private val camera = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        if (bitmap != null) {
            coverPath = ImageUtil.saveImageFromCamera(requireContext(), bitmap)
            Glide.with(this).load(coverPath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddBookBinding.bind(view)
        if (!requireTeacherOrHome()) return
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("scanned_qr")?.observe(viewLifecycleOwner) { qr ->
            binding.bookFields.qrInput.setText(qr)
        }

        binding.bookFields.categoryInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, listOf("Story", "Science", "History")))
        binding.galleryButton.setOnClickListener { gallery.launch("image/*") }
        binding.takePhotoButton.setOnClickListener { camera.launch(null) }
        binding.bookFields.generateQrButton.text = "Open Scanner"
        binding.bookFields.generateQrButton.setOnClickListener {
            findNavController().navigate(R.id.scanFragment, Bundle().apply { putBoolean("forResult", true) })
        }
        binding.saveButton.setOnClickListener { save() }
    }

    private fun save() {
        val title = binding.bookFields.titleInput.text?.toString()?.trim().orEmpty()
        val author = binding.bookFields.authorInput.text?.toString()?.trim().orEmpty()
        val pages = binding.bookFields.pagesInput.text?.toString()?.toIntOrNull()
        val category = binding.bookFields.categoryInput.text?.toString()?.trim().orEmpty()
        val qr = binding.bookFields.qrInput.text?.toString()?.trim().orEmpty()
        if (title.isBlank() || author.isBlank() || pages == null || category.isBlank() || coverPath.isBlank() || qr.isBlank()) {
            Snackbar.make(binding.root, "Title, author, pages, category, cover image, and printed QR code are required.", Snackbar.LENGTH_LONG).show()
            return
        }
        vm.addBook(BookEntity(title = title, author = author, category = category, coverImagePath = coverPath, summaryKannada = binding.bookFields.summaryInput.text?.toString().orEmpty(), totalPages = pages, qrCode = qr, addedDate = System.currentTimeMillis(), addedByTeacherId = session().getUserId())) {
            Snackbar.make(binding.root, "Book added!", Snackbar.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }
}

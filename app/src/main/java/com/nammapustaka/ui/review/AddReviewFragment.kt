package com.nammapustaka.ui.review

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.data.entity.ReviewEntity
import com.nammapustaka.databinding.FragmentAddReviewBinding
import com.nammapustaka.ui.session

class AddReviewFragment : Fragment(R.layout.fragment_add_review) {
    private lateinit var binding: FragmentAddReviewBinding
    private val vm: ReviewViewModel by viewModels()
    private val bookId get() = arguments?.getInt("bookId") ?: 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddReviewBinding.bind(view)
        if (session().getUserRole() != "student") { Snackbar.make(binding.root, "Student access only", Snackbar.LENGTH_SHORT).show(); findNavController().popBackStack(); return }
        vm.book(bookId).observe(viewLifecycleOwner) { book ->
            if (book != null) {
                binding.titleText.text = book.title
                binding.authorText.text = book.author
                Glide.with(this).load(book.coverImagePath).placeholder(R.drawable.placeholder_book).into(binding.coverImage)
            }
        }
        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ -> binding.ratingLabel.text = listOf("", "Poor", "Fair", "Good", "Great", "Excellent!")[rating.toInt()] }
        binding.submitButton.setOnClickListener {
            val rating = binding.ratingBar.rating.toInt()
            if (rating <= 0) binding.ratingLabel.text = "Rating required" else vm.submit(ReviewEntity(bookId = bookId, studentId = session().getUserId(), starRating = rating, reviewText = binding.reviewInput.text?.toString().orEmpty().take(150), reviewDate = System.currentTimeMillis())) {
                Snackbar.make(binding.root, "Review submitted", Snackbar.LENGTH_SHORT).show(); findNavController().popBackStack()
            }
        }
    }
}

package com.nammapustaka.ui.review

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nammapustaka.NammaPustakaApp
import com.nammapustaka.data.entity.ReviewEntity
import kotlinx.coroutines.launch

class ReviewViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    fun book(id: Int) = app.bookRepository.book(id).asLiveData()
    fun submit(review: ReviewEntity, done: () -> Unit) = viewModelScope.launch { app.reviewRepository.insert(review); done() }
}

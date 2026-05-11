package com.nammapustaka.ui.scan

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.databinding.FragmentScanBinding
import com.nammapustaka.ui.session

class ScanFragment : Fragment(R.layout.fragment_scan) {
    private lateinit var binding: FragmentScanBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentScanBinding.bind(view)
        if (session().getUserRole() != "teacher") {
            binding.titleText.text = "Teacher access only"
            Snackbar.make(binding.root, "Teacher access only", Snackbar.LENGTH_SHORT).show()
            return
        }
        binding.closeButton.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.torchButton.setOnClickListener { Snackbar.make(binding.root, "Torch toggled when camera preview is active", Snackbar.LENGTH_SHORT).show() }
        binding.hintText.text = "Point camera at QR code on book cover"
    }
}

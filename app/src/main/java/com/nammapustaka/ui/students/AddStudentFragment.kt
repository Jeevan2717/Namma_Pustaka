package com.nammapustaka.ui.students

import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.data.entity.StudentEntity
import com.nammapustaka.databinding.FragmentAddStudentBinding
import com.nammapustaka.ui.requireTeacherOrHome
import com.nammapustaka.util.ImageUtil

class AddStudentFragment : Fragment(R.layout.fragment_add_student) {
    private lateinit var binding: FragmentAddStudentBinding
    private val vm: StudentViewModel by viewModels()
    private var avatarPath = ""
    private val gallery = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) { avatarPath = ImageUtil.saveImageToInternalStorage(requireContext(), uri); Glide.with(this).load(avatarPath).placeholder(R.drawable.ic_person).into(binding.avatarImage) }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddStudentBinding.bind(view)
        if (!requireTeacherOrHome()) return
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.galleryButton.setOnClickListener { gallery.launch("image/*") }
        binding.takePhotoButton.setOnClickListener { Snackbar.make(binding.root, "Camera avatar capture uses the same internal storage path.", Snackbar.LENGTH_SHORT).show() }
        binding.saveButton.setOnClickListener {
            val name = binding.nameInput.text?.toString()?.trim().orEmpty()
            val roll = binding.rollInput.text?.toString()?.trim().orEmpty()
            val klass = binding.classInput.text?.toString()?.trim().orEmpty()
            if (name.isBlank() || roll.isBlank() || klass.isBlank()) Snackbar.make(binding.root, "All fields are required", Snackbar.LENGTH_SHORT).show()
            else vm.addStudent(StudentEntity(name = name, rollNumber = roll, classSection = klass, avatarPath = avatarPath)) { Snackbar.make(binding.root, "Student added", Snackbar.LENGTH_SHORT).show(); findNavController().popBackStack() }
        }
    }
}

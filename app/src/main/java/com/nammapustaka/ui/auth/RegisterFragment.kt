package com.nammapustaka.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.databinding.FragmentAuthBinding
import kotlinx.coroutines.launch

class RegisterFragment : Fragment(R.layout.fragment_auth) {
    private lateinit var binding: FragmentAuthBinding
    private val vm: AuthViewModel by viewModels()
    private var role = "teacher"
    private var linkedStudentId: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAuthBinding.bind(view)
        binding.primaryButton.text = "Register"
        binding.linkText.text = "Already have account? Login"
        binding.roleToggle.check(R.id.teacherButton)
        binding.linkStudentLayout.visibility = View.GONE
        binding.roleToggle.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                role = if (checkedId == R.id.teacherButton) "teacher" else "student"
                binding.linkStudentLayout.visibility = if (role == "student") View.VISIBLE else View.GONE
            }
        }
        vm.students.observe(viewLifecycleOwner) { students ->
            val labels = if (students.isEmpty()) listOf("Create new student profile") else students.map { "${it.name} (${it.rollNumber})" }
            binding.linkStudentInput.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, labels))
            binding.linkStudentInput.setOnItemClickListener { _, _, position, _ -> linkedStudentId = students.getOrNull(position)?.id }
        }
        binding.passwordInput.setOnEditorActionListener { _, _, _ -> updateStrength(); false }
        binding.primaryButton.setOnClickListener { register() }
        binding.linkText.setOnClickListener { findNavController().navigate(R.id.action_register_to_login) }
    }

    private fun updateStrength() {
        val p = binding.passwordInput.text?.toString().orEmpty()
        binding.passwordStrength.progress = listOf(p.length * 8, if (p.any(Char::isDigit)) 20 else 0, if (p.any { !it.isLetterOrDigit() }) 20 else 0).sum().coerceAtMost(100)
    }

    private fun register() {
        val fullName = binding.fullNameInput.text?.toString()?.trim().orEmpty()
        val username = binding.usernameInput.text?.toString()?.trim().orEmpty()
        val password = binding.passwordInput.text?.toString().orEmpty()
        val confirm = binding.confirmInput.text?.toString().orEmpty()
        if (fullName.isBlank() || username.isBlank() || password.length < 6 || password != confirm) {
            Snackbar.make(binding.root, "Check all fields. Passwords must match and be at least 6 chars.", Snackbar.LENGTH_LONG).show()
            return
        }
        lifecycleScope.launch {
            if (!vm.usernameAvailable(username)) {
                binding.usernameLayout.error = "Username already exists"
            } else {
                vm.register(fullName, username, password, role, linkedStudentId)
                Snackbar.make(binding.root, "Registered. Please login.", Snackbar.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_register_to_login)
            }
        }
    }
}

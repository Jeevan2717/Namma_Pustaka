package com.nammapustaka.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.databinding.FragmentAuthBinding
import com.nammapustaka.util.SessionManager
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_auth) {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val vm: AuthViewModel by viewModels()
    private var role = "teacher"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentAuthBinding.bind(view)
        binding.fullNameLayout.visibility = View.GONE
        binding.confirmLayout.visibility = View.GONE
        binding.passwordStrength.visibility = View.GONE
        binding.linkStudentLayout.visibility = View.GONE
        binding.roleToggle.check(R.id.teacherButton)
        binding.roleToggle.addOnButtonCheckedListener { _, checkedId, isChecked -> if (isChecked) role = if (checkedId == R.id.teacherButton) "teacher" else "student" }
        binding.primaryButton.text = "Login"
        binding.primaryButton.setOnClickListener { login() }
        binding.linkText.setOnClickListener { findNavController().navigate(R.id.action_login_to_register) }
    }

    private fun login() {
        val username = binding.usernameInput.text?.toString()?.trim().orEmpty()
        val password = binding.passwordInput.text?.toString().orEmpty()
        binding.usernameLayout.error = if (username.isBlank()) "Username required" else null
        binding.passwordLayout.error = if (password.isBlank()) "Password required" else null
        if (username.isBlank() || password.isBlank()) return
        lifecycleScope.launch {
            val user = vm.login(username, password, role)
            if (user == null) {
                binding.passwordLayout.error = "Wrong credentials for selected role"
            } else {
                SessionManager(requireContext()).saveSession(user.id, user.role, user.fullName)
                findNavController().navigate(R.id.action_login_to_home)
            }
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}

package com.nammapustaka.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nammapustaka.R
import com.nammapustaka.util.SessionManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            delay(2000)
            val action = if (SessionManager(requireContext()).isLoggedIn()) R.id.action_splash_to_home else R.id.action_splash_to_login
            findNavController().navigate(action)
        }
    }
}

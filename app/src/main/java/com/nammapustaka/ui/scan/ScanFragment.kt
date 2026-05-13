package com.nammapustaka.ui.scan

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.OptIn
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.nammapustaka.R
import com.nammapustaka.databinding.FragmentScanBinding
import com.nammapustaka.ui.session
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ScanFragment : Fragment(R.layout.fragment_scan) {
    private lateinit var binding: FragmentScanBinding
    private val viewModel: ScanViewModel by viewModels()
    private lateinit var cameraExecutor: ExecutorService
    private var camera: Camera? = null
    private var isProcessing = false

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) startCamera()
        else Snackbar.make(binding.root, "Camera permission required", Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentScanBinding.bind(view)
        if (session().getUserRole() != "teacher") {
            binding.titleText.text = "Teacher access only"
            Snackbar.make(binding.root, "Teacher access only", Snackbar.LENGTH_SHORT).show()
            return
        }
        cameraExecutor = Executors.newSingleThreadExecutor()
        
        binding.closeButton.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.torchButton.setOnClickListener { toggleTorch() }
        
        animateScanLine()

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun allPermissionsGranted() = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(binding.previewView.surfaceProvider)
            }
            
            val scanner = BarcodeScanning.getClient()
            val imageAnalysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
            
            imageAnalysis.setAnalyzer(cameraExecutor) { imageProxy ->
                processImageProxy(scanner, imageProxy)
            }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                cameraProvider.unbindAll()
                camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis)
            } catch (exc: Exception) {
                Snackbar.make(binding.root, "Use of camera failed", Snackbar.LENGTH_SHORT).show()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    @OptIn(ExperimentalGetImage::class)
    private fun processImageProxy(barcodeScanner: BarcodeScanner, imageProxy: ImageProxy) {
        if (isProcessing) {
            imageProxy.close()
            return
        }
        val mediaImage = imageProxy.image ?: run { imageProxy.close(); return }
        val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
        barcodeScanner.process(image)
            .addOnSuccessListener { barcodes ->
                if (barcodes.isNotEmpty() && !isProcessing) {
                    barcodes[0].rawValue?.let { qr ->
                        onBarcodeDetected(qr)
                    }
                }
            }
            .addOnCompleteListener { imageProxy.close() }
    }

    private fun onBarcodeDetected(qr: String) {
        isProcessing = true
        val forResult = arguments?.getBoolean("forResult") ?: false
        if (forResult) {
            findNavController().previousBackStackEntry?.savedStateHandle?.set("scanned_qr", qr)
            findNavController().popBackStack()
            return
        }
        lifecycleScope.launch {
            val book = viewModel.bookByQr(qr)
            if (book == null) {
                Snackbar.make(binding.root, "Book not found: $qr", Snackbar.LENGTH_SHORT).show()
                // Wait a bit before allowing another scan
                kotlinx.coroutines.delay(2000)
                isProcessing = false
            } else {
                val activeTx = viewModel.activeForBook(book.id)
                if (activeTx == null) {
                    IssueBookBottomSheet.newInstance(book.id).show(childFragmentManager, "issue")
                } else {
                    ReturnBookDialog.newInstance(book.id).show(childFragmentManager, "return")
                }
                // The dialogs will handle resetting the state or the user will navigate away
                // But let's add a way to resume when dialog is closed
                childFragmentManager.registerFragmentLifecycleCallbacks(object : androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentDestroyed(fm: androidx.fragment.app.FragmentManager, f: Fragment) {
                        if (f is IssueBookBottomSheet || f is ReturnBookDialog) {
                            isProcessing = false
                            childFragmentManager.unregisterFragmentLifecycleCallbacks(this)
                        }
                    }
                }, false)
            }
        }
    }

    private fun toggleTorch() {
        val current = camera?.cameraInfo?.torchState?.value == TorchState.ON
        camera?.cameraControl?.enableTorch(!current)
    }

    private fun animateScanLine() {
        binding.scanLine.post {
            val parent = binding.scanLine.parent as View
            val distance = parent.height.toFloat() - binding.scanLine.height.toFloat()
            val animation = android.view.animation.TranslateAnimation(0f, 0f, 0f, distance)
            animation.duration = 2000
            animation.repeatMode = android.view.animation.Animation.REVERSE
            animation.repeatCount = android.view.animation.Animation.INFINITE
            binding.scanLine.startAnimation(animation)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cameraExecutor.shutdown()
    }
}

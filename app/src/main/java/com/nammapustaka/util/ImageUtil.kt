package com.nammapustaka.util

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

object ImageUtil {
    fun saveImageToInternalStorage(context: Context, uri: Uri): String {
        val dir = File(context.filesDir, "covers").apply { mkdirs() }
        val file = File(dir, "${UUID.randomUUID()}.jpg")
        context.contentResolver.openInputStream(uri)?.use { input ->
            FileOutputStream(file).use { output -> input.copyTo(output) }
        }
        return file.absolutePath
    }

    fun saveImageFromCamera(context: Context, bitmap: Bitmap): String {
        val dir = File(context.filesDir, "covers").apply { mkdirs() }
        val file = File(dir, "${UUID.randomUUID()}.jpg")
        FileOutputStream(file).use { bitmap.compress(Bitmap.CompressFormat.JPEG, 92, it) }
        return file.absolutePath
    }
}

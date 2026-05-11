package com.nammapustaka.util

object QRUtil {
    fun generate(): String = "NMPSTK_${System.currentTimeMillis()}"
    fun isValid(s: String): Boolean = s.startsWith("NMPSTK_")
}

package com.nammapustaka.util

import java.security.MessageDigest

object HashUtil {
    fun sha256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun verify(input: String, hash: String): Boolean = sha256(input) == hash
}

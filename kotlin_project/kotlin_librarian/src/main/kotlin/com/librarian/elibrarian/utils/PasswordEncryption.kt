package com.librarian.elibrarian.utils

import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import java.util.Arrays
import java.util.Base64
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

class PasswordEncryption {
    private val random: SecureRandom = SecureRandom()
    private val characters: String = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    private val iterations: Int = 10000
    private val keyLength: Int = 256

    fun getSaltValue(length: Int): String {
        val finalVal: StringBuilder = StringBuilder(length)

        for(i in 0..length) {
            finalVal.append(characters[random.nextInt(characters.length)])
        }

        return String(finalVal)
    }

    private fun hash(password: CharArray, salt: ByteArray): ByteArray {
        val spec: PBEKeySpec = PBEKeySpec(password, salt, iterations, keyLength)
        Arrays.fill(password, Character.MIN_VALUE)

        try {
            val skf: SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            return skf.generateSecret(spec).encoded
        } catch (e: NoSuchAlgorithmException) {
            throw AssertionError("Error while hashing password: {}", e)
        } catch (e: InvalidKeySpecException) {
            throw AssertionError("Error while hashing password: {}", e)
        } finally {
            spec.clearPassword()
        }
    }

    fun generateSecurePassword(password: String, salt: String): String {
        var finalVal: String? = null
        val securePassword: ByteArray = hash(password.toCharArray(), salt.toByteArray())
        finalVal = Base64.getEncoder().encodeToString(securePassword)

        return finalVal
    }

    private fun verifyUserPassword(providedPassword: String, securePassword: String, salt: String): Boolean {
        var finalVal: Boolean = false

        val newSecurePassword: String = generateSecurePassword(providedPassword, salt)

        finalVal = newSecurePassword.equals(securePassword, ignoreCase = true)

        return finalVal
    }

    fun passwordValidate(password: String): Boolean {
        val hashedPassword: String = ""
        val hashedSecretKey: String = ""

        return verifyUserPassword(password, hashedPassword, hashedSecretKey)
    }

    fun userAuthentication(password: String, hashedPassword: String, hashedSecretKey: String): Boolean {
        return verifyUserPassword(password, hashedPassword, hashedSecretKey)
    }
}

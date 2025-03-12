package com.example.duadm_post.utils

import org.junit.Assert.*

import org.junit.Test

class MyValidatorTest {

    private val validationUtils = MyValidator()

    @Test
    fun testIsValidEmail_ValidEmail_ReturnsTrue() {
        val validEmail = "test@example.com"
        val result = validationUtils.isValidEmail(validEmail)
        assertTrue("Valid email should return true", result)
    }

    @Test
    fun testIsValidEmail_InvalidEmailWithoutAt_ReturnsFalse() {
        val invalidEmail = "testexample.com"
        val result = validationUtils.isValidEmail(invalidEmail)
        assertFalse("Email without '@' should return false", result)
    }

    @Test
    fun testIsValidEmail_InvalidEmailWithoutDomain_ReturnsFalse() {
        val invalidEmail = "test@.com"
        val result = validationUtils.isValidEmail(invalidEmail)
        assertFalse("Email without domain should return false", result)
    }

    @Test
    fun testIsValidEmail_EmptyEmail_ReturnsFalse() {
        val emptyEmail = ""
        val result = validationUtils.isValidEmail(emptyEmail)
        assertFalse("Empty email should return false", result)
    }

    @Test
    fun testIsValidEmail_InvalidEmailWithSpaces_ReturnsFalse() {
        val invalidEmail = "test @example.com"
        val result = validationUtils.isValidEmail(invalidEmail)
        assertFalse("Email with spaces should return false", result)
    }

    @Test
    fun testIsValidEmail_EmailWithSpecialChars_ReturnsTrue() {
        val validEmail = "test+alias@example.com"
        val result = validationUtils.isValidEmail(validEmail)
        assertTrue("Email with special characters like '+' should return true", result)
    }

    @Test
    fun testIsValidEmail_InvalidEmailWithMultipleAtSymbols_ReturnsFalse() {
        val invalidEmail = "test@@example.com"
        val result = validationUtils.isValidEmail(invalidEmail)
        assertFalse("Email with multiple '@' symbols should return false", result)
    }
}
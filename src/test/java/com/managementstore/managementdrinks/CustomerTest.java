package com.managementstore.managementdrinks;

import org.junit.Test;
import static org.junit.Assert.*;
public class CustomerTest {

    @Test
    public void testEmailValidation() {
        // Valid emails (should return true)
        assertTrue(CustomerValidator.isValidEmail("test@example.com"));
        assertTrue(CustomerValidator.isValidEmail("user.name@domain.co"));

        // Invalid emails (should return false)
        assertFalse(CustomerValidator.isValidEmail("invalid-email"));
        assertFalse(CustomerValidator.isValidEmail("user@.com"));
        assertFalse(CustomerValidator.isValidEmail("@domain.com"));

        // Edge cases
        assertFalse(CustomerValidator.isValidEmail(null));
        assertFalse(CustomerValidator.isValidEmail(""));
    }
}
package org.example.passgen.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    @Test
    public void testPasswordLength() {
        int passwordLength = 8;
        String password = passwordGenerator.generateNewPassword(passwordLength);
        assertEquals(passwordLength, password.length(), "Password length must be " + passwordLength);
    }

    @Test
    public void testPasswordContainsRequiredCharacters() {
        String password = passwordGenerator.generateNewPassword(8);

        assertTrue(password.chars().anyMatch(Character::isLowerCase), "Password must contain lowercase characters");
        assertTrue(password.chars().anyMatch(Character::isUpperCase), "Password must contain uppercase characters");
        assertTrue(password.chars().anyMatch(Character::isDigit), "Password must contain digit characters");
        assertTrue(password.chars().anyMatch(ch -> "!@#$%^&*()_+".indexOf((char) ch) >= 0), "Password must contain at least one character");
    }

    @Test
    public void testPasswordTooShort() {
        String result = passwordGenerator.generateNewPassword(3);
        assertEquals("Password length should be at least 4", result, "Password length should be at least 4");
    }

    @Test
    public void testUniquePasswords() {
        String password1 = passwordGenerator.generateNewPassword(8);
        String password2 = passwordGenerator.generateNewPassword(8);
        assertNotEquals(password1, password2, "Each password must be unique");
    }
}
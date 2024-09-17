package org.example.passgen.tools;

import java.util.Random;

public class PasswordGenerator {

    private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final String NUMBERS = "0123456789";

    private final String SYMBOLS = "!@#$%^&*()_+";

    public String generateNewPassword(int length) {
        if (length < 4) {
            return "Password length should be at least 4";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        password.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        password.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

        String allCharacters = LETTERS + CAPITAL_LETTERS + NUMBERS + SYMBOLS;

        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        StringBuilder shuffledPassword = new StringBuilder(password.length());
        while (password.length() > 0) {
            int index = random.nextInt(password.length());
            shuffledPassword.append(password.charAt(index));
            password.deleteCharAt(index);
        }
        return shuffledPassword.toString();
    }
}


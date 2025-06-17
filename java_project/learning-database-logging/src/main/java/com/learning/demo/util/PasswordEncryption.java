package com.learning.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryption {

    public void simplePasswordEncryption() {
        String password = "";
        String saltValue = PassBasedEnc.getSaltValue(30);

        String encryptedPassword = PassBasedEnc.generateSecurePassword(password, saltValue);

        System.out.println("Plain text password = " + password);
        System.out.println("Secure password = " + encryptedPassword);
        System.out.println("Salt value = " + saltValue);

        // verify the original password and encrypted password
        String hash_ps = "";
        String salt = saltValue;
        boolean status = PassBasedEnc.verifyUserPassword(password, hash_ps, salt);

        if (status) {
            System.out.println("Password Matched!!");
        } else {
            System.out.println("Password Mismatched");
        }
    }

    public void hashPasswordWithMessageDigest() {
        String password = "";
        String encryptedPassword = null;
        try {
            // MessageDigest instance for MD5.
            MessageDigest m = MessageDigest.getInstance("MD5");

            // Add plain-text password bytes to digest using MD5 update() method.
            m.update(password.getBytes());

            // Convert the hash value into bytes
            byte[] bytes = m.digest();

            // The bytes array has bytes in decimal form. Converting it into hexadecimal format.
            StringBuilder s = new StringBuilder();
            for (byte aByte : bytes) {
                s.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            // Complete hashed password in hexadecimal format
            encryptedPassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error when encrypting the password");
        }

        // Display the unencrypted and encrypted passwords
        System.out.println("Plain-text password: " + password);
        System.out.println("Encrypted password using MD5: " + encryptedPassword);
    }
}

class PassBasedEnc {
    private static final SecureRandom random = new SecureRandom();
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 100000;
    private static final int keylength = 256;

    public static String getSaltValue(int length) {
        StringBuilder finalval = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            finalval.append(characters.charAt(random.nextInt(characters.length())));
        }
        return new String(finalval);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String generateSecurePassword(String password, String salt) {
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

        return Base64.getEncoder().encodeToString(securePassword);
    }

    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }

}

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
        String password = "password@1234";
         String saltvalue = PassBasedEnc.getSaltvalue(30);

         String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue);

         System.out.println("Plain text password = " + password);
         System.out.println("Secure password = " + encryptedpassword);
         System.out.println("Salt value = " + saltvalue);

         // verify the original password and encrypted password
         String hash_ps = "diqJFbdL7Mvtr2fhAQA2QCcEGBZLJr8oxEoACfPKqv4=";
         String salt = "RvSn1lzkaqzuTHpoCc5wdyQpYjhpz4";   
         Boolean status = PassBasedEnc.verifyUserPassword(password,hash_ps,salt);
 
         if(status) {
         	System.out.println("Password Matched!!");
         } else  {
         	System.out.println("Password Mismatched");
         }
    }
    
    public void hashPasswordWithMessageDigest() {
    	String password = "password@1234";
        String encryptedpassword = null;
        try {
            // MessageDigest instance for MD5.
            MessageDigest m = MessageDigest.getInstance("MD5");

            // Add plain-text password bytes to digest using MD5 update() method.
            m.update(password.getBytes());

            // Convert the hash value into bytes
            byte[] bytes = m.digest();

            // The bytes array has bytes in decimal form. Converting it into hexadecimal format.
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Complete hashed password in hexadecimal format
            encryptedpassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Display the unencrypted and encrypted passwords
        System.out.println("Plain-text password: " + password);
        System.out.println("Encrypted password using MD5: " + encryptedpassword);
    }
}

class PassBasedEnc {
    private static final SecureRandom random = new SecureRandom();
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 100000;
    private static final int keylength = 256;

    public static String getSaltvalue(int length) {
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
        String finalval = null;

        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

	    finalval = Base64.getEncoder().encodeToString(securePassword);

		return finalval;
    }

    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
        boolean finalval = false;
        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        finalval = newSecurePassword.equalsIgnoreCase(securedPassword);
        return finalval;
    }

}

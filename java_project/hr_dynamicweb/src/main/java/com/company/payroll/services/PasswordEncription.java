package com.company.payroll.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncription {
	// Declaration of variables
    private static final SecureRandom random = new SecureRandom();  
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
    private static final int iterations = 10000;  
    private static final int keylength = 256;  
    
    /**
     * Method to generate the salt value.
     * @param	lentgh
     * 			Salt value length
     * @return	salt string
     * */
    public static String getSaltvalue(int length) {  
        StringBuilder finalval = new StringBuilder(length);  
  
        for (int i = 0; i < length; i++) {  
            finalval.append(characters.charAt(random.nextInt(characters.length())));  
        }  
        return new String(finalval);  
    }
    
    /**
     * Method to generate the hash value
     * @param	password
     * 			Array character password
     * @param	salt
     * 			Salt value
     * */
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
  
    /**
     * Method to encrypt the password using the original password and salt value.
     * @param	password
     * 			Get string password
     * @param	salt
     * 			Get salt value
     * @return	Base64 string
     * */
    public static String generateSecurePassword(String password, String salt) {  
        String finalval = null;  
  
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());  
   
        finalval = Base64.getEncoder().encodeToString(securePassword);  
   
        return finalval;  
    }
    
    /**
     * Method to verify if both password matches or not 
     * @param	providedPassword
     * 			Get password string
     * @param	securePassword
     * 			Get Encrypted password
     * @param	salt
     * 			Get salt value
     * @return	boolean
     * */
    public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {  
        boolean finalval = false;  
          
        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);  
          
        // Check if two passwords are equal
        finalval = newSecurePassword.equalsIgnoreCase(securedPassword);
        return finalval;  
    }
}

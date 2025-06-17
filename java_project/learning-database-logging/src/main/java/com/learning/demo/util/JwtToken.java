package com.learning.demo.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtToken {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Base64.Encoder ENCODER = Base64.getUrlEncoder();
    private static final String SUB = "user-subject-001";

    public static void main(String[] args) {
        long ttl = 3600;
        Date expired = new Date(System.currentTimeMillis() + ttl);
        String secretString = "yourVeryLongAndSecureSecretKeyForHS512SigningThatIsAtLeast64BytesLong";
        SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));

        // Generate token
        String token = Jwts.builder()
                .claims()
                .subject(SUB)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expired)
                .and()
                .signWith(key, Jwts.SIG.HS512)
                .compact();

        /**
         * Output will contains value such as header, payload(claims) and signature.
         * Json strings may looks like xxxxxxxx.xxxxxxxx.xxxxxxx
         */
        System.out.println("Json web token: " + token);

        // Get token claims value
        Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();

        System.out.println("Subject inside claims: " + claims.getSubject());

        byte[] bytes = new byte[20];
        RANDOM.nextBytes(bytes);
        String token2 = ENCODER.encodeToString(bytes);

        System.out.println("A secure random token: " + token2);
    }
}

package com.learning.demo.util;

import java.security.Key;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtToken {
	private static final SignatureAlgorithm ALG = SignatureAlgorithm.HS512;
	private static final SecureRandom RANDOM = new SecureRandom();
	private static final Base64.Encoder ENCODER = Base64.getUrlEncoder();
	private static final String SUB = "user-subject-001";
	
	public static void main(String[] args) {
	    long ttl = 3600;
	    Date expired = new Date(System.currentTimeMillis() + ttl);
	    Key key = Keys.secretKeyFor(ALG);

	    // Generate token
	    String token = Jwts.builder()
				    		.setSubject(SUB)
				            .setExpiration(expired)
				            .signWith(key)
				            .compact();

	    /**
	     * Output will contains value such as header, payload(claims) and signature.
	     * Json strings may looks like xxxxxxxx.xxxxxxxx.xxxxxxx
	     */
	    System.out.println("Json web token: " + token);

	    // Get token claims value
	    Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	    
	    System.out.println("Subject inside claims: " + claims.getSubject().toString());
	    
	    byte bytes[] = new byte[20];
	    RANDOM.nextBytes(bytes);
	    String token2 = ENCODER.encodeToString(bytes);

	    System.out.println("A secure random token: " + token2);
	}
}

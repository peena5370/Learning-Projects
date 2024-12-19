package com.learning.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.demo.util.PasswordEncryption;

public class MainApplication {
	private final static Logger log = LoggerFactory.getLogger(MainApplication.class);
	
	public static void main(String[] args) {
		log.warn("warn from main application");
		
		PasswordEncryption passwordEncryption = new PasswordEncryption();
		
		passwordEncryption.simplePasswordEncryption();
		passwordEncryption.hashPasswordWithMessageDigest();
	}

}

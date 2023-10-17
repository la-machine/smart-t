package com.bezkoder.springjwt.security.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
    
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

}

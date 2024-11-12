package com.jwtPractise;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class A {
    public static void main(String[] args) {


        String passwrd = "sushmita";
        String password = BCrypt.hashpw(passwrd, BCrypt.gensalt(5));
        System.out.println(password);
    }
}

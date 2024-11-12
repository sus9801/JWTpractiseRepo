package com.jwtPractise.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JwtService {
    @Value("${jwt.algorithm.key}")
    private String keyAlgorithm;
    @Value("${jwt.issuer}")
    private String isser;
    @Value("${jwt.expiary.duration}")
    private int expiry;
    private Algorithm algorithm;
    @PostConstruct
    public void postConstruct()throws UnsupportedEncodingException {
        algorithm=Algorithm.HMAC256(keyAlgorithm);
    }

    public String createToken(String username){
        return JWT.create().withClaim("name",username).
                withExpiresAt(new Date(System.currentTimeMillis()+expiry)).
                withIssuer(isser).sign(algorithm);
    }

    public String extractUsername(String token){
        DecodedJWT decodedJWT=JWT.require(algorithm).withIssuer(isser).build().verify(token);
        return decodedJWT.getClaim("name").asString();
    }


}

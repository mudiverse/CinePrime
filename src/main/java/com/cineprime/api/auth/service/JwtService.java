package com.cineprime.api.auth.service;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.cineprime.api.user.entity.User;

@Service
public class JwtService {

    private static final Logger log = LoggerFactory.getLogger(JwtService.class);

    @Value("${jwt.secret}")
    private String secret;


    public String  generateToken(User user) throws IllegalArgumentException,JWTCreationException{
        return JWT.create()
        .withSubject(user.getEmail())
        .withClaim("role",user.getRole())
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 hours expiry
        .sign(Algorithm.HMAC256(secret));
    }


    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            // Log so you can see why validation failed (expired vs bad signature vs malformed)
            log.warn("JWT validation failed: {}", e.getMessage());
            return false;
        }
    }


    public String loadEmailFromToken(String token) {
        //token se email extract karenge, jisse user details fetch kar sake
        return JWT.decode(token).getSubject(); //token decode karenge, aur subject me email milega
    }



}

package com.cineprime.api.auth.service;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cineprime.api.common.constants.AppConstants;
import com.cineprime.api.dto.AuthResponse;
import com.cineprime.api.dto.LoginRequest;
import com.cineprime.api.dto.RegisterRequest;
import com.cineprime.api.user.entity.User;
import com.cineprime.api.user.repositories.UserRepo;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public @Nullable Object register(RegisterRequest user) {
        //this method will Store user in database, and password encode

        if(userRepo.existsByEmail(user.getEmail())){
            throw new RuntimeException("User already exists with this email");
        }

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        //pass encode karna hai, to passwordEncoder ka use karenge, jisse password secure ho jayega
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(AppConstants.ROLE_USER);

        userRepo.save(newUser); //user ko save karenge database me, userRepo ke through


        return "USer Registerd Successfully";
    }

    public @Nullable Object login(LoginRequest loginRequest) {
        //pahle get user 
        User newUser = userRepo.findByEmail(loginRequest.getEmail())
        .orElseThrow(()-> new RuntimeException("User not found with this email"));

        //new user milgya so match the hashed pass
        if(!passwordEncoder.matches(loginRequest.getPassword(),newUser.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        //generate a JWT token using jwt service

        String token = jwtService.generateToken(newUser); //yaha pe token generate karenge, jisse user future requests me use kar sake, for now dummy token return karenge


       return new AuthResponse(token);
    }
    
}

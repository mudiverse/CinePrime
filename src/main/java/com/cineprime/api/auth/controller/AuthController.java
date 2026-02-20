package com.cineprime.api.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineprime.api.auth.service.AuthService;
import com.cineprime.api.dto.LoginRequest;
import com.cineprime.api.dto.RegisterRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController{

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerHandler(@RequestBody  RegisterRequest user){ 
        //reg krne ke loiye AuthService call hoga jo Store karega user, and password encode
        
        return ResponseEntity.ok(authService.register(user));
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginHandler(@RequestBody LoginRequest loginRequest){ //user credentials aaega request body me, usko hum receive karenge yaha
        return ResponseEntity.ok(authService.login(loginRequest)); //login method call hoga AuthService me, 
        // jisme user credentials jayenge, aur waha se response aayega, usko hum return karenge client ko
    }
    
}

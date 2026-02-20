package com.cineprime.api.user.service.impl;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import com.cineprime.api.user.entity.User;
import com.cineprime.api.user.repositories.UserRepo;

import com.cineprime.api.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo; // Assuming you have a UserRepo interface for database operations

    @Override
    public User saveUser(User user) {

        

        //encrypt password before saving user to database
        // String encryptedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encryptedPassword);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
       return userRepo.findByEmail(email);
    }


}

package com.cineprime.api.user.service;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.cineprime.api.user.entity.User;


public interface UserService {
    
    User saveUser(User user);

    Optional<User> findByEmail(String email);

}

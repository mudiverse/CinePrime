package com.cineprime.api.configs;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cineprime.api.auth.service.JwtService;
import com.cineprime.api.user.entity.User;
import com.cineprime.api.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter   extends OncePerRequestFilter{

    @Autowired
    private JwtService jwtService;  

    @Autowired
    private UserService userService; //user details fetch karne ke liye, jisse token me user info dal sake, aur future me validate kar sake


 //this will be used to intercept incoming requests and validate the JWT token, 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.isBlank()) {
            filterChain.doFilter(request, response);
            return;
        }
        String trimmed = authHeader.trim();
        // Accept "Bearer " case-insensitively (some clients send "bearer ")
        if (!trimmed.regionMatches(true, 0, "Bearer ", 0, 7)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = trimmed.substring(7).trim();
        if (token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //validation of token

        if(!jwtService.validateToken(token)){
            //if token is invalid, then return 401 unauthorized
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
        }

        String userEmail = jwtService.loadEmailFromToken(token); //token se email extract karenge, jisse user details fetch kar sake

        //load user from db by using email
        User user = userService.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("User not found with this email from token"));

        //create Auth Response ka object
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            user, //principal me user object dalenge, jisse future me use kar sake
            null, //credentials null rakhenge, kyunki hum password se authenticate nahi kar rahe, token se kar rahe hai
            user.getAuthorities() //authorities me user ke roles dalenge, jisse future me access control me use kar sake
        );

        //set context
        SecurityContextHolder.getContext().setAuthentication(authentication); //security context me authentication set karenge, jisse future me use kar sake
        filterChain.doFilter(request, response);
    }
   
       
}

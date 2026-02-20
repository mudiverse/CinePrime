package com.cineprime.api.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

}

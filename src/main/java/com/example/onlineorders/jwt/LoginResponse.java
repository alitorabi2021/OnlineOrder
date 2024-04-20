package com.example.onlineorders.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginResponse {
    private String token;

    private long expiresIn;

}

// Getters and setters...
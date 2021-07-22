package com.manuels.principal.models;

import lombok.Data;

@Data
public class AuthenticationResponse {
    
    private final String jwt;
}
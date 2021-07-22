package com.manuels.principal.models;

import lombok.Data;

@Data
public class AuthenticationRequest {
    
    public AuthenticationRequest(){}
    
    private String username;
    private String password;
}
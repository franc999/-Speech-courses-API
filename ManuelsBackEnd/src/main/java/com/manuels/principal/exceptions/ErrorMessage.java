package com.manuels.principal.exceptions;

import lombok.Data;

@Data
public class ErrorMessage {
    
    private String exception;
    private String message;
    private String path;
    
    public ErrorMessage(Exception ex, String path){
        
        this.exception = ex.getClass().getSimpleName();
        this.message = ex.getMessage();
        this.path = path;
    }
}

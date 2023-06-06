package com.Facturacion2023.Facturacion2023.Models;

public class JWTResponse {
    private String token;

    public JWTResponse(String token){
        this.token = token;
    }

    public JWTResponse(){

    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}

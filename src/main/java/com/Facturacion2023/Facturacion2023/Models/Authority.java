package com.Facturacion2023.Facturacion2023.Models;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;

    public Authority (String authority){

        this.authority=authority;
    }
    @Override
    public String getAuthority(){
        return this.authority;
    }
}

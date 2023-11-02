package com.Facturacion2023.Facturacion2023.Exception;

public class UsuarioNotFoundException extends Exception {
    public UsuarioNotFoundException(){
        super("El Usuario no está en uso.");
    }

    public UsuarioNotFoundException(String message){
        super(message);
    }
}

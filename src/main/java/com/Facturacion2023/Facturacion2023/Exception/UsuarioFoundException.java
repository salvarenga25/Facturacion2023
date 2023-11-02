package com.Facturacion2023.Facturacion2023.Exception;

public class UsuarioFoundException extends Exception{
    public UsuarioFoundException(){
        super("El Usuario está en uso, intente con otro Usuario");
    }
    public UsuarioFoundException(String message){
        super(message);
    }
}

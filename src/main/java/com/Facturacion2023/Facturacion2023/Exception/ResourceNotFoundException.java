package com.Facturacion2023.Facturacion2023.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long seriaVersionID = 1L;
    public ResourceNotFoundException(String msj){
        super(msj);
    }


}

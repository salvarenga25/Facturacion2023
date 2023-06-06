package com.Facturacion2023.Facturacion2023.Servicios;

import com.Facturacion2023.Facturacion2023.Models.Usuario;
import com.Facturacion2023.Facturacion2023.Models.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}

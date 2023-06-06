package com.Facturacion2023.Facturacion2023.Repositories;

import com.Facturacion2023.Facturacion2023.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    public Usuario findByUsername(String username);
}

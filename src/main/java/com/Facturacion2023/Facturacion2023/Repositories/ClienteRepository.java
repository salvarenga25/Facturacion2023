package com.Facturacion2023.Facturacion2023.Repositories;

import com.Facturacion2023.Facturacion2023.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c from Cliente c WHERE dnioruc = :dnioruc ")
    Cliente  findByDnioruc(String dnioruc);
}

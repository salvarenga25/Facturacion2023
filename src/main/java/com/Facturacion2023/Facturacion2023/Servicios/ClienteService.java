package com.Facturacion2023.Facturacion2023.Servicios;

import com.Facturacion2023.Facturacion2023.Models.Cliente;

import java.util.Set;

public interface ClienteService {
    Cliente guardarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    Set<Cliente> listarCliente();
    Cliente listaclientexDnioruc(String dnioruc);
    Cliente listaclientesxRazon(String razon);
    void eliminarCliente(Integer indice);

}

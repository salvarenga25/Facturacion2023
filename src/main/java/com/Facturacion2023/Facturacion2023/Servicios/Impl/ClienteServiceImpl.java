package com.Facturacion2023.Facturacion2023.Servicios.Impl;

import com.Facturacion2023.Facturacion2023.Models.Cliente;
import com.Facturacion2023.Facturacion2023.Repositories.ClienteRepository;
import com.Facturacion2023.Facturacion2023.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Set<Cliente> listarCliente() {
        return new LinkedHashSet<>(clienteRepository.findAll());
    }

    @Override
    public Cliente listaclientexDnioruc(String dnioruc) {
        return clienteRepository.findByDnioruc(dnioruc);
    }

    @Override
    public Cliente listaclientesxRazon(String razon) {
        return clienteRepository.findByRazon(razon);
    }

    @Override
    public void eliminarCliente(Integer indice) {
        Cliente cli = new Cliente();
        cli.setIndice(indice);
        clienteRepository.delete(cli);
    }
}

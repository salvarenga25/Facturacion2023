package com.Facturacion2023.Facturacion2023.Servicios.Impl;

import com.Facturacion2023.Facturacion2023.Models.Marca;
import com.Facturacion2023.Facturacion2023.Repositories.MarcaRepository;
import com.Facturacion2023.Facturacion2023.Servicios.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca registrarMarca(Marca marca){
        return marcaRepository.save(marca);
    }

    @Override
    public Marca actualizarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Set<Marca> listarMarca() {
        return new LinkedHashSet<>(marcaRepository.findAll());
    }

    @Override
    public Marca buscarMarca(Integer idMarca) {
        return marcaRepository.findById(idMarca).get();
    }

    @Override
    public void eliminarMarca(Integer idMarca) {
       Marca m = new Marca();
       m.setIdMarca(idMarca);
       marcaRepository.delete(m);
    }
}

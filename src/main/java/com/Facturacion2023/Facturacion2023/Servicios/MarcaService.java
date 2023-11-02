package com.Facturacion2023.Facturacion2023.Servicios;

import com.Facturacion2023.Facturacion2023.Models.Marca;

import java.util.Set;

public interface MarcaService {
    //CRUD OPERATIONS
    Marca registrarMarca(Marca marca);
    Marca actualizarMarca(Marca marca);
    Set<Marca> listarMarca();

    Marca buscarMarca(Integer idMarca);
    void eliminarMarca(Integer idMarca);

}

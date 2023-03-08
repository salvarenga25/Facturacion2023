package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Marca;
import com.Facturacion2023.Facturacion2023.Repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    MarcaRepository marcaRepository;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarcas(){

        return ResponseEntity.ok(marcaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Marca> guardarMarca(@Valid @RequestBody Marca marcaAregistrar){
        Marca MarcaGuardada = marcaRepository.save(marcaAregistrar);
        URI rutaEnvio = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{/idMarca}")
                .buildAndExpand(MarcaGuardada.getIdMarca()).toUri();
        return ResponseEntity.created(rutaEnvio).body(MarcaGuardada);
    }

    @PutMapping("/{idMarca}")                    //Como la uri necesita una llave primaria, por eso llamamos a pathVariable y el tipo de la llave Primaria
    public ResponseEntity<Marca> actualizarMarca(@PathVariable Integer idMarca, @Valid @RequestBody Marca marcaAactualizar){
        Optional<Marca> MarcaVerificar = marcaRepository.findById(idMarca); //se enfoca en buscar si la marca a modifica si existe

        //si la marca no existe, response que no se pudo procesar
        if(!MarcaVerificar.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        marcaAactualizar.setIdMarca(MarcaVerificar.get().getIdMarca());
        marcaRepository.save(marcaAactualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idMarca}")
    public ResponseEntity<Map<String,Boolean>> eliminarMarca(@PathVariable Integer idMarca){
        Marca marcaEliminar = marcaRepository.findById(idMarca)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la marca con el id: " + idMarca));

        marcaRepository.delete(marcaEliminar);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

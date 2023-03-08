package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Comprobante;
import com.Facturacion2023.Facturacion2023.Repositories.ComprobanteRepository;
import org.apache.coyote.Response;
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
@RequestMapping("/comprobante")
public class ComprobanteController  {
    @Autowired
    ComprobanteRepository comprobanteRepository;

    @GetMapping
    public ResponseEntity<List<Comprobante>> listarComprobantes(){

        return ResponseEntity.ok(comprobanteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Comprobante> guardarComprobante(@Valid @RequestBody Comprobante comprobanteAregistrar){
        Comprobante ComprobanteGuardado = comprobanteRepository.save(comprobanteAregistrar);
        URI rutaEnvio = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{indice}")
                .buildAndExpand(ComprobanteGuardado.getIndice()).toUri();
        return ResponseEntity.created(rutaEnvio).body(ComprobanteGuardado);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Comprobante> actualizarComprobante(@PathVariable Integer indice,@Valid @RequestBody Comprobante comprobanteAactualizar){
        Optional<Comprobante> ComprobanteVerificar = comprobanteRepository.findById(indice);

        if(!ComprobanteVerificar.isPresent()){

            return ResponseEntity.unprocessableEntity().build();

        }
        comprobanteAactualizar.setIndice(ComprobanteVerificar.get().getIndice());
        comprobanteRepository.save(comprobanteAactualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Map<String,Boolean>> eliminarComprobante(@PathVariable Integer indice){
        Comprobante comprobanteEliminar = comprobanteRepository.findById(indice).
                orElseThrow(() -> new ResourceNotFoundException("No existe el comprobante con el id: " + indice));

        comprobanteRepository.delete(comprobanteEliminar);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

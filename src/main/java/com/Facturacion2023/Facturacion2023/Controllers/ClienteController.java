package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Cliente;


import com.Facturacion2023.Facturacion2023.Repositories.ClienteRepository;
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
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){

        return ResponseEntity.ok(clienteRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@Valid @RequestBody Cliente clienteAregistrar){
        Cliente ClienteGuardado = clienteRepository.save(clienteAregistrar);
        URI rutaEnvio = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{indice}")
                .buildAndExpand(ClienteGuardado.getIndice()).toUri();
        return ResponseEntity.created(rutaEnvio).body(ClienteGuardado);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer indice,@Valid @RequestBody Cliente clienteAactualizar){
        Optional<Cliente> clienteVerificar = clienteRepository.findById(indice);
        if(!clienteVerificar.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        clienteAactualizar.setIndice(clienteVerificar.get().getIndice());
        clienteRepository.save(clienteAactualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable Integer indice){
        Cliente ClienteEliminar = clienteRepository.findById(indice)
                .orElseThrow(() -> new ResourceNotFoundException("No existe cliente con indice: " + indice));

        clienteRepository.delete(ClienteEliminar);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Cliente> buscarClienteIndice(@PathVariable Integer indice){
     Cliente clienteAbuscar = clienteRepository.findById(indice)
             .orElseThrow(()-> new ResourceNotFoundException("\n\nNo existe cliente con indice: "  + indice + "\n\n"));

        return ResponseEntity.ok(clienteAbuscar);

    }
    @GetMapping("/dni/{dnioruc}")
    public ResponseEntity<Cliente> buscarClientexDnioRuc(@PathVariable String dnioruc){
        Cliente clienteAbuscar = clienteRepository.findByDnioruc(dnioruc);

        return ResponseEntity.ok(clienteAbuscar);
    }
}

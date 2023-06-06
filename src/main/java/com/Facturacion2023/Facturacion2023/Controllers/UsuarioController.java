package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Models.Usuario;
import com.Facturacion2023.Facturacion2023.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){

        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> GuardarUsuario(@Valid @RequestBody Usuario usuarioAguardar){
        Usuario usuarioGuardado = usuarioRepository.save(usuarioAguardar);
        URI rutaEnvio = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioGuardado.getId()).toUri();
        return ResponseEntity.created(rutaEnvio).body(usuarioGuardado);

    }
}

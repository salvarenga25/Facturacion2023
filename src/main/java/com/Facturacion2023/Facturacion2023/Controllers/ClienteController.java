package com.Facturacion2023.Facturacion2023.Controllers;


import com.Facturacion2023.Facturacion2023.Models.Cliente;
import com.Facturacion2023.Facturacion2023.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/cliente")
@CrossOrigin("*") //you give the privilege to the specific route you can consume the service
public class  ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente clienteAregistrar){
        Cliente ClienteGuardado = clienteService.guardarCliente(clienteAregistrar);
        return ResponseEntity.ok(ClienteGuardado);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarClientes(){
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @GetMapping("/dni/{dnioruc}")
    public Cliente listarClientexDnioRuc(@PathVariable("dnioruc") String dnioruc){
        return clienteService.listaclientexDnioruc(dnioruc);
    }
    @GetMapping("/razon/{razon}")
    public Cliente listarClientexRazon(@PathVariable("razon") String razon){
        return clienteService.listaclientesxRazon(razon);
    }

    @PutMapping("/")
    public Cliente actualizarCliente(@RequestBody Cliente clienteAactualizar){
        return clienteService.actualizarCliente(clienteAactualizar);
    }

    @DeleteMapping("/{indice}")
    public void eliminarCliente(@PathVariable Integer indice) {

    }


}

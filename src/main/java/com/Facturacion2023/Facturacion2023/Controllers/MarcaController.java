package com.Facturacion2023.Facturacion2023.Controllers;


import com.Facturacion2023.Facturacion2023.Models.Marca;
import com.Facturacion2023.Facturacion2023.Servicios.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/marca")
@CrossOrigin("*")
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @PostMapping("/")
    public ResponseEntity<Marca> guardarMarca(@RequestBody Marca marcaAregistrar){
        Marca MarcaGuardada = marcaService.registrarMarca(marcaAregistrar);
        return ResponseEntity.ok(MarcaGuardada);

    }
    @GetMapping("/")
    public ResponseEntity<?> listarMarcasporId(){

        return ResponseEntity.ok(marcaService.listarMarca());
    }

    @GetMapping("/{idmarca}")
    public Marca listarMarcasporId(@PathVariable("idmarca") Integer idmarca){

        return marcaService.buscarMarca(idmarca);
    }

    @PutMapping("/")
    public Marca actualizarMarca(@RequestBody Marca marca){
        return marcaService.actualizarMarca(marca);
    }

   @DeleteMapping("/{idMarca}")
    public void eliminarMarca(@PathVariable("idmarca") Integer idmarca){
        marcaService.eliminarMarca(idmarca);
   }
}

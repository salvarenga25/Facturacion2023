package com.Facturacion2023.Facturacion2023.Models;




import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="marca")
public class Marca {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable=false)
    private Integer idMarca;
   @NotNull
    private String nombre;
    @OneToMany(mappedBy = "marca", cascade=CascadeType.ALL)
    @JsonIgnore //indica que solo va a traer los datos, pero en los JSON va a ignorar estos productos para evitrar errores
    private Set<Producto> productos = new LinkedHashSet<>();

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
        for (Producto prod: productos){

            prod.setMarca(this);
        }
    }
}

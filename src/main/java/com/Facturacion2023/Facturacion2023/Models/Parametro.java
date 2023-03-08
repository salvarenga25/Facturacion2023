package com.Facturacion2023.Facturacion2023.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parametro")
public class Parametro {
    @Id
    @Column(unique = true, nullable = false)
    private String nombre;
    private Integer valorentero;
    private Double valordecimal;
    private String valorstring;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValorentero() {
        return valorentero;
    }

    public void setValorentero(Integer valorentero) {
        this.valorentero = valorentero;
    }

    public Double getValordecimal() {
        return valordecimal;
    }

    public void setValordecimal(double valordecimal) {
        this.valordecimal = valordecimal;
    }

    public String getValorstring() {
        return valorstring;
    }

    public void setValorstring(String valorstring) {
        this.valorstring = valorstring;
    }
}

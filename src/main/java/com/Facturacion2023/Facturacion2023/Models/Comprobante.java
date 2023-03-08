package com.Facturacion2023.Facturacion2023.Models;

import javax.persistence.*;

@Entity
@Table(name="comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer indice;
    private String punto_venta;
    private String nombre;
    private String serie;
    private String correlativo;

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getPunto_venta() {
        return punto_venta;
    }

    public void setPunto_venta(String punto_venta) {
        this.punto_venta = punto_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
}

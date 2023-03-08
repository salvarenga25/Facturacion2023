package com.Facturacion2023.Facturacion2023.Models;


import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer indice;

    //@Column(name="tipodoc")
    private String tipodoc;

    @NotNull
    //@Column(name="dnioruc")
    private String dnioruc;

    @NotNull
    //@Column(name="razon")
    private String razon;
    @NotNull
    //@Column(name="direccion")
    private String direccion;

    //@Column(name="celular")
    private String celular;

    //@Column(name="email")
    private  String email;

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getDnioruc() {
        return dnioruc;
    }

    public void setDnioruc(String dnioruc) {
        this.dnioruc = dnioruc;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

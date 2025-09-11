package com.example.hibernate.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Producto {
    @ManyToOne
    private Agencia agencia;

    private String producto_id;

    public String getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(String producto_id) {
        this.producto_id = producto_id;
    }
}

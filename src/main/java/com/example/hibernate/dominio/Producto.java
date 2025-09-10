package com.example.hibernate.dominio;

import javax.persistence.ManyToOne;

public class Producto {
    @ManyToOne
    private Agencia agencia;
}

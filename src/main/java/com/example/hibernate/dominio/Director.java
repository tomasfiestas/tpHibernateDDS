package com.example.hibernate.dominio;

import javax.persistence.OneToMany;
import java.util.List;

public class Director {
    @OneToMany
    private List<Busqueda> busquedas;

    public List<Busqueda> getBusquedas() {
        return busquedas;
    }

    public void setBusquedas(List<Busqueda> busquedas) {
        this.busquedas = busquedas;
    }
}

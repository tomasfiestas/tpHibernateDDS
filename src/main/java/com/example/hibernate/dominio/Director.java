package com.example.hibernate.dominio;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class Director {
    @OneToMany
    private List<Busqueda> busquedas;

    private String director_id;

    public List<Busqueda> getBusquedas() {
        return busquedas;
    }

    public void setBusquedas(List<Busqueda> busquedas) {
        this.busquedas = busquedas;
    }

    public String getDirector_id() {
        return director_id;
    }

    public void setDirector_id(String director_id) {
        this.director_id = director_id;
    }
}

package com.example.hibernate.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends Creador{

    @OneToMany(mappedBy = "creador") // inversa de Busqueda.creador (ManyToOne)
    private List<Busqueda> busquedas;

    public List<Busqueda> getBusquedas() { return busquedas; }
    public void setBusquedas(List<Busqueda> busquedas) { this.busquedas = busquedas; }
    }



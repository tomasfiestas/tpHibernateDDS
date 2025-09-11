package com.example.hibernate.dominio;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("AGENCIA")
public class Agencia extends Creador {

    @OneToMany
    private List<Busqueda> busquedas;
    @OneToMany
    private List<Producto> productos;

    public List<Busqueda> getBusqueda() {
        return busquedas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setBusquedas(List<Busqueda> busquedas) {
        this.busquedas = busquedas;
    }

}

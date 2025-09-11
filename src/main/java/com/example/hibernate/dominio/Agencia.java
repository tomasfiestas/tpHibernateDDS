package com.example.hibernate.dominio;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("AGENCIA")
public class Agencia extends Creador {

    @OneToMany(mappedBy = "creador")
    private List<Busqueda> busquedas = new ArrayList<>();

    // Inversa de Producto.agencia → NO crea join table
    @OneToMany(mappedBy = "agencia")
    private List<Producto> productos = new ArrayList<>();

    // getters/setters
    public List<Busqueda> getBusquedas() { return busquedas; }  // plural para coherencia
    public void setBusquedas(List<Busqueda> busquedas) { this.busquedas = busquedas; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

}

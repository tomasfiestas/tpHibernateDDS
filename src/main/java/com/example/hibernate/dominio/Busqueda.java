package com.example.hibernate.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class Busqueda {

    @Id
    private String busqueda_id;
    private GENEROPERSONA generoPersona;
    private tipoBusqueda tipoBusqueda;
    private GENERO generoObra;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "creador_id", nullable = false)
    private Creador creadorBusqueda;
    private Integer edad;

    @ElementCollection
    @CollectionTable(
            name = "busqueda_requisitos",
            joinColumns = @JoinColumn(name = "busqueda_id", nullable = false)
    )
    @Column(name = "requisito", nullable = false, length = 255)
    private List<String> requisitos;
    private String tipoRenumeracion;
    private String localizacion;
    private String informacionAdicional;
    private ESTADOBUSQUEDA estadobusqueda;

    @OneToMany(mappedBy = "busqueda")
    private List<Postulacion> postulantes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;


    public String getBusqueda_id() {
        return busqueda_id;
    }

    public void setBusqueda_id(String busqueda_id) {
        this.busqueda_id = busqueda_id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public GENEROPERSONA getGeneroPersona() {
        return generoPersona;
    }

    public void setGeneroPersona(GENEROPERSONA generoPersona) {
        this.generoPersona = generoPersona;
    }

    public tipoBusqueda getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(tipoBusqueda tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public GENERO getGeneroObra() {
        return generoObra;
    }

    public void setGeneroObra(GENERO generoObra) {
        this.generoObra = generoObra;
    }

    public List<String> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<String> requisitos) {
        this.requisitos = requisitos;
    }

    public String getTipoRenumeracion() {
        return tipoRenumeracion;
    }

    public void setTipoRenumeracion(String tipoRenumeracion) {
        this.tipoRenumeracion = tipoRenumeracion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public List<Postulacion> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(List<Postulacion> postulantes) {
        this.postulantes = postulantes;
    }

    public ESTADOBUSQUEDA getEstadobusqueda() {
        return estadobusqueda;
    }

    public void setEstadobusqueda(ESTADOBUSQUEDA estadobusqueda) {
        this.estadobusqueda = estadobusqueda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Creador getCreadorBusqueda() {
        return creadorBusqueda;
    }

    public void setCreadorBusqueda(Creador creadorBusqueda) {
        this.creadorBusqueda = creadorBusqueda;
    }
}

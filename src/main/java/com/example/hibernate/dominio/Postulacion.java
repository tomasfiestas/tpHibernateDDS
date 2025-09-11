package com.example.hibernate.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Postulacion {

    @Id
    private String postulacion_id;

    @ManyToOne
    private Actor usuario;

    private ESTADOPOSTULACION estadopostulacion;
    private Date fechaPostulacion;
    private String reelActor;
    private String cvActor;
    private String fotosActor;

    @ManyToOne
    private Busqueda busqueda;


    public Actor getUsuario() {
        return usuario;
    }

    public void setUsuario(Actor usuario) {
        this.usuario = usuario;
    }

    public ESTADOPOSTULACION getEstadopostulacion() {
        return estadopostulacion;
    }

    public void setEstadopostulacion(ESTADOPOSTULACION estadopostulacion) {
        this.estadopostulacion = estadopostulacion;
    }

    public String getPostulacion_id() {
        return postulacion_id;
    }

    public void setPostulacion_id(String postulacion_id) {
        this.postulacion_id = postulacion_id;
    }

    public String getReelActor() {
        return reelActor;
    }

    public void setReelActor(String reelActor) {
        this.reelActor = reelActor;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public String getCvActor() {
        return cvActor;
    }

    public void setCvActor(String cvActor) {
        this.cvActor = cvActor;
    }

    public String getFotosActor() {
        return fotosActor;
    }

    public void setFotosActor(String fotosActor) {
        this.fotosActor = fotosActor;
    }

    public Busqueda getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(Busqueda busqueda) {
        this.busqueda = busqueda;
    }
}

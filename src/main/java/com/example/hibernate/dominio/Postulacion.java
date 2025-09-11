package com.example.hibernate.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // si la asignás vos, quitá esta línea
    @Column(name = "postulacion_id")
    private Long postulacion_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)    // es obligatoria según tu regla
    @JoinColumn(name = "actor_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_postulacion_actor"))
    private Actor usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_postulacion", nullable = false)
    private ESTADOPOSTULACION estadopostulacion;

    @Temporal(TemporalType.TIMESTAMP)                       // si pasás a Java Time, usamos LocalDateTime y sacamos esto
    @Column(name = "fecha_postulacion", nullable = false)
    private Date fechaPostulacion;

    @Column(length = 500)
    private String reelActor;

    @Column(length = 500)
    private String cvActor;

    @Column(length = 500)
    private String fotosActor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)    // también obligatoria
    @JoinColumn(name = "busqueda_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_postulacion_busqueda"))
    private Busqueda busqueda;

    public Long getPostulacionId() {
        return postulacion_id;
    }                 // JavaBean friendly

    public void setPostulacionId(Long id) {
        this.postulacion_id = id;
    }

    public Actor getUsuario() {
        return usuario;
    }

    public void setUsuario(Actor usuario) {
        this.usuario = usuario;
    }

    public ESTADOPOSTULACION getEstadopostulacion() {
        return estadopostulacion;
    }

    public void setEstadopostulacion(ESTADOPOSTULACION estado) {
        this.estadopostulacion = estado;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public String getReelActor() {
        return reelActor;
    }

    public void setReelActor(String reelActor) {
        this.reelActor = reelActor;
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

package com.example.hibernate.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "busquedas")
public class Busqueda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busqueda_id;

    @Enumerated(EnumType.STRING)
    private GENEROPERSONA generoPersona;

    @Enumerated(EnumType.STRING)
    private TIPOBUSQUEDA tipoBusqueda;

    @Enumerated(EnumType.STRING)
    private GENERO generoObra;

    // FK a la tabla base 'creador' (herencia SINGLE_TABLE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "creador_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_busqueda_creador")
    )
    private Creador creador;   // ← antes: creadorBusqueda

    private Integer edad;

    @ElementCollection
    @CollectionTable(
            name = "busqueda_requisitos",
            joinColumns = @JoinColumn(name = "busqueda_id", nullable = false)
    )
    @Column(name = "requisito", nullable = false, length = 255)
    private List<String> requisitos = new ArrayList<>();

    private String tipoRenumeracion; // dejo tu nombre tal cual
    private String localizacion;

    @Column(length = 2000)
    private String informacionAdicional;

    @Enumerated(EnumType.STRING)
    private ESTADOBUSQUEDA estadobusqueda;

    @OneToMany(mappedBy = "busqueda")
    private List<Postulacion> postulantes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    // ----- getters/setters -----

    public Long getBusqueda_id() { return busqueda_id; }
    public void setBusqueda_id(Long busqueda_id) { this.busqueda_id = busqueda_id; }

    public GENEROPERSONA getGeneroPersona() { return generoPersona; }
    public void setGeneroPersona(GENEROPERSONA generoPersona) { this.generoPersona = generoPersona; }

    public TIPOBUSQUEDA getTipoBusqueda() { return tipoBusqueda; }
    public void setTipoBusqueda(TIPOBUSQUEDA tipoBusqueda) { this.tipoBusqueda = tipoBusqueda; }

    public GENERO getGeneroObra() { return generoObra; }
    public void setGeneroObra(GENERO generoObra) { this.generoObra = generoObra; }

    public Creador getCreador() { return creador; }
    public void setCreador(Creador creador) { this.creador = creador; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public List<String> getRequisitos() { return requisitos; }
    public void setRequisitos(List<String> requisitos) { this.requisitos = requisitos; }

    public String getTipoRenumeracion() { return tipoRenumeracion; }
    public void setTipoRenumeracion(String tipoRenumeracion) { this.tipoRenumeracion = tipoRenumeracion; }

    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }

    public String getInformacionAdicional() { return informacionAdicional; }
    public void setInformacionAdicional(String informacionAdicional) { this.informacionAdicional = informacionAdicional; }

    public ESTADOBUSQUEDA getEstadobusqueda() { return estadobusqueda; }
    public void setEstadobusqueda(ESTADOBUSQUEDA estadobusqueda) { this.estadobusqueda = estadobusqueda; }

    public List<Postulacion> getPostulantes() { return postulantes; }
    public void setPostulantes(List<Postulacion> postulantes) { this.postulantes = postulantes; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
}
package com.example.hibernate.dominio;

import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor") // fuerza el nombre físico en minúsculas
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id") // mantiene el nombre de columna que ya venías usando
    private Long actor_id;

    @OneToMany(mappedBy = "usuario")
    private List<Postulacion> postulaciones = new ArrayList<>();

    @Column(name = "nombre", length = 200, nullable = true)
    private String nombre;

    public Long getActorId() { return actor_id; }         // JavaBean correcto
    public void setActorId(Long actor_id) { this.actor_id = actor_id; }
    public List<Postulacion> getPostulaciones() { return postulaciones; }
    public void setPostulaciones(List<Postulacion> postulaciones) { this.postulaciones = postulaciones; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

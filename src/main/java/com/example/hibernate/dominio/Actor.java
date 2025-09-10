package com.example.hibernate.dominio;

import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String actor_id;

    @OneToMany(mappedBy = "usuario")
    private List<Postulacion> postulaciones = new ArrayList<>();

    public String getactor_Id() { return actor_id; }
    public List<Postulacion> getPostulaciones() { return postulaciones; }
    public void setactor_id(String actor_id) { this.actor_id = actor_id; }

}

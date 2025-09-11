package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_creador")
public abstract class Creador {

    @Id
    private String id;

    public String getId() { return id; }
}

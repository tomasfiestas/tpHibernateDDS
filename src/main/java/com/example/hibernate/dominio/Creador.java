package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name = "creador")                        // ← fuerza minúsculas
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_creador")
public abstract class Creador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
}

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

    @Column(name = "nombre", length = 200, nullable = true) // ponelo en true si ya tenés filas
    private String nombre;


    public Long getId() { return id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

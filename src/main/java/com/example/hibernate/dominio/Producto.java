package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long producto_id;

    @Column(name = "nombre", length = 200, nullable = true)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "agencia_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_producto_agencia")
    )
    private Agencia agencia;


    // getters/setters (JavaBean)
    public Long getProductoId() { return producto_id; }
    public void setProductoId(Long producto_id) { this.producto_id = producto_id; }

    public Agencia getAgencia() { return agencia; }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

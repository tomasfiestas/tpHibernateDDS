package com.example.hibernate;

import com.example.hibernate.dominio.*;
import com.example.hibernate.utils.BDUtils;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        try {
            BDUtils.comenzarTransaccion(em);

            // 1) Creador concreto (usa la tabla base 'creador' vía SINGLE_TABLE)
            Agencia agencia = new Agencia();
            em.persist(agencia);

            // 2) Producto que pertenece a esa agencia
            Producto prod = new Producto();
            prod.setAgencia(agencia);
            em.persist(prod);

            // 3) Búsqueda que referencia al creador (polimórfico) y al producto
            Busqueda b = new Busqueda();
            b.setCreador(agencia); // clave: el ManyToOne apunta a la tabla 'creador'
            b.setProducto(prod);

            // Ajustá estas constantes a tus enums reales
            b.setGeneroPersona(GENEROPERSONA.MASCULINO);      // ej.
            b.setTipoBusqueda(TIPOBUSQUEDA.PELICULA);  // ej.
            b.setGeneroObra(GENERO.TERROR);                    // ej.
            b.setEstadobusqueda(ESTADOBUSQUEDA.ACTIVA);      // ej.

            b.setEdad(25);
            b.setLocalizacion("CABA");
            b.setTipoRenumeracion("A convenir");
            b.setInformacionAdicional("Prueba de cámara el lunes 10hs");
            b.setRequisitos(new ArrayList<>(Arrays.asList(
                    "Actuación teatral", "Disponibilidad fines de semana"
            )));
            em.persist(b);

            // 4) Actor
            Actor actor = new Actor();
            em.persist(actor);

            // 5) Postulación que une Actor con Búsqueda
            Postulacion p = new Postulacion();
            p.setUsuario(actor);
            p.setBusqueda(b);
            p.setEstadopostulacion(ESTADOPOSTULACION.INICIADA); // ajustá el enum
            p.setFechaPostulacion(new Date());
            p.setReelActor("https://mi-reel.com/actor123");
            p.setCvActor("cv_actor_123.pdf");
            p.setFotosActor("foto1.jpg");
            em.persist(p);

            BDUtils.commit(em);
            System.out.println("OK: se persistieron Agencia, Producto, Busqueda, Actor y Postulacion.");
        } finally {
            if (em.isOpen()) em.close();
        }
    }
}




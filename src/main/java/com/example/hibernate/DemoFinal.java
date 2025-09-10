package com.example.hibernate;

import com.example.hibernate.utils.BDUtils;
import java.time.LocalDateTime;
import static java.util.Arrays.asList;
import java.util.List;
import javax.persistence.EntityManager;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

//        try {
            Alumno marcos = new Alumno();
            //Insert
            em.persist(marcos);
//        } catch (Exception e) {
//            BDUtils.rollback(em);
//            return;
//        }

        //Update
        marcos.setNombre("Marcos"); //Entidad administrada -> detecta cambios
        marcos.setPromedio(6.75);

        Curso dds = new Curso();
        dds.setHorario(LocalDateTime.now());
        em.persist(dds); //antes de asociar entidades deben estar persistidas

        marcos.setCursos(asList(dds));

        System.out.println("ID MARCOS: " + marcos.getId());

        Profesor julian = new Profesor();
        julian.setNombre("Julian");
        julian.setSalario(1000.55);

        em.persist(julian);

        //examen
        Examen examenDeMarcos = new Examen();
        examenDeMarcos.setAlumno(marcos);
        examenDeMarcos.setCalificacion(Calificacion.BIEN);
        examenDeMarcos.setNota(6);

        em.persist(examenDeMarcos);

        //JPQL Query
        List<Persona> personas = em
                // equivalente a: select * from persona where persona.nombre = 'Julian'
                .createQuery("select p from Persona p where p.nombre = ?1", Persona.class) //ojo, query no tipada
                .setParameter(1, "Julian")
                .getResultList();

        System.out.println(personas);

        //Delete
        for (Persona persona : personas) {
            em.remove(persona);
        }

        BDUtils.commit(em);
    }

}

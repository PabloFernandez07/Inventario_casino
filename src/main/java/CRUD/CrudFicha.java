/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Pojos.Fichas;
import Pojos.Items;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import org.hibernate.PersistentObjectException;

/**
 *
 * @author pablo
 */
public class CrudFicha {

    public static List<Fichas> getListFichas() {
        List<Fichas> listaFichas = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Fichas.findAll");
            listaFichas = query.getResultList();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la biblioteca. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return listaFichas;
    }
    
    public static Fichas getFichasNombre(String nombre) {
        Fichas ficha = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Fichas.findByNombre");
            query.setParameter("nombre", nombre);
            ficha = (Fichas) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la biblioteca. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return ficha;
    }

    public static Fichas crearFicha(Fichas f) {
        EntityManager em = Conexion.conecta();

        try {
            em.getTransaction().begin();
            em.merge(f); //Guarda el objeto Juego como peristente
            em.getTransaction().commit();
        } catch (RollbackException | PersistentObjectException ex) {
            System.out.println("Error al grabar los datos. " + ex.getLocalizedMessage());
            try {
                em.getTransaction().rollback();
            } catch (PersistenceException e) {
                System.out.println("Error grave. no puedo deshacer los cambios. " + ex.getLocalizedMessage());
            }
        }

        return f;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Pojos.Items;
import Pojos.Transacciones;
import java.sql.Date;
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
public class CrudTransaccion {

    public static List<Transacciones> getListTransaccioneses() {
        List<Transacciones> listaTransaccioneses = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Transacciones.findAll");
            listaTransaccioneses = query.getResultList();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la transaccion. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return listaTransaccioneses;
    }

    public static List<Transacciones> getTransaccionesesFecha(Date fecha) {
        List<Transacciones> listaTransaccioneses = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Transacciones.findByFecha");
            query.setParameter("fecha", fecha);
            listaTransaccioneses = query.getResultList();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la biblioteca. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return listaTransaccioneses;
    }
    
    public static List<Transacciones> getTransaccionesPersona(String persona) {
        List<Transacciones> listaTransaccioneses = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Transacciones.findByPersonaAnade");
            query.setParameter("personaAnade", persona);
            listaTransaccioneses = query.getResultList();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la biblioteca. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return listaTransaccioneses;
    }

    public static Transacciones crearTransaccion(Transacciones t) {
        EntityManager em = Conexion.conecta();

        try {
            em.getTransaction().begin();
            em.merge(t); //Guarda el objeto Juego como peristente
            em.getTransaction().commit();
        } catch (RollbackException | PersistentObjectException ex) {
            System.out.println("Error al grabar los datos. " + ex.getLocalizedMessage());
            try {
                em.getTransaction().rollback();
            } catch (PersistenceException e) {
                System.out.println("Error grave. no puedo deshacer los cambios. " + ex.getLocalizedMessage());
            }
        }
        return t;
    }

}

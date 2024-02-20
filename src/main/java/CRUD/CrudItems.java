/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
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
public class CrudItems {

    public static List<Items> getListItems() {
        List<Items> listaItems = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Items.findAll");
            listaItems = query.getResultList();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la biblioteca. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return listaItems;
    }

    public static Items getItemNombre(String nombre) {
        Items item = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Items.findByNombre");
            query.setParameter("nombre", nombre);
            item = (Items) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No encuentro la biblioteca. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }

        Conexion.desconecta(em);

        return item;
    }

    public static void actualizarCantidad(Items item, int cantidadAnadir) {
        EntityManager em = Conexion.conecta();
        try {
            String jpql = "UPDATE items i SET i.cantidad=:cantidad";
            Query query = em.createQuery(jpql);
            int cantidad = item.getCantidad() + cantidadAnadir;
            query.setParameter("cantidad", cantidad);
            query.executeUpdate();
        } catch (IllegalArgumentException ex) {
            System.err.println("ERROR en los argumentos. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public static Items crearItem(Items item) {
        EntityManager em = Conexion.conecta();

        try {
            em.getTransaction().begin();
            em.merge(item); //Guarda el objeto Juego como peristente
            em.getTransaction().commit();
        } catch (RollbackException | PersistentObjectException ex) {
            System.out.println("Error al grabar los datos. " + ex.getLocalizedMessage());
            try {
                em.getTransaction().rollback();
            } catch (PersistenceException e) {
                System.out.println("Error grave. no puedo deshacer los cambios. " + ex.getLocalizedMessage());
            }
        }

        return item;
    }

}

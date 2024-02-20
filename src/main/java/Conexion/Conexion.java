/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dam211
 */
public class Conexion {
    private final String UNITNAME = "espablo_Inventario_jar_0.1.2024PU";
    
    private static EntityManagerFactory emFactory;
    private static EntityManager em;
    
    public Conexion(){
        this.emFactory = Persistence.createEntityManagerFactory(UNITNAME);
    }
    
    /**
     * Metodo para crear la conexion
     * @return 
     */
    public static EntityManager conecta(){
        em = emFactory.createEntityManager();
        
        return em;
    }
    
    /**
     * Metodo para desconectarse de la conexion
     * @param em 
     */
    public static void desconecta(EntityManager em){
        if(em != null){
            em.close();
        }
    }
    
    
}

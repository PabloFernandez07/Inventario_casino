/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByPkitem", query = "SELECT i FROM Items i WHERE i.pkitem = :pkitem"),
    @NamedQuery(name = "Items.findByNombre", query = "SELECT i FROM Items i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Items.findByCantidad", query = "SELECT i FROM Items i WHERE i.cantidad = :cantidad")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkitem")
    private Integer pkitem;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkitem")
    private List<Transacciones> transaccionesList;

    public Items() {
    }

    public Items(Integer pkitem) {
        this.pkitem = pkitem;
    }

    public Items(Integer pkitem, String nombre, int cantidad) {
        this.pkitem = pkitem;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Integer getPkitem() {
        return pkitem;
    }

    public void setPkitem(Integer pkitem) {
        this.pkitem = pkitem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<Transacciones> getTransaccionesList() {
        return transaccionesList;
    }

    public void setTransaccionesList(List<Transacciones> transaccionesList) {
        this.transaccionesList = transaccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkitem != null ? pkitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.pkitem == null && other.pkitem != null) || (this.pkitem != null && !this.pkitem.equals(other.pkitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pojos.Items[ pkitem=" + pkitem + " ]";
    }
    
}

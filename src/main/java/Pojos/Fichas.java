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
@Table(name = "fichas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichas.findAll", query = "SELECT f FROM Fichas f"),
    @NamedQuery(name = "Fichas.findByPkficha", query = "SELECT f FROM Fichas f WHERE f.pkficha = :pkficha"),
    @NamedQuery(name = "Fichas.findByNombre", query = "SELECT f FROM Fichas f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Fichas.findByMote", query = "SELECT f FROM Fichas f WHERE f.mote = :mote"),
    @NamedQuery(name = "Fichas.findByTelefono", query = "SELECT f FROM Fichas f WHERE f.telefono = :telefono"),
    @NamedQuery(name = "Fichas.findByStateId", query = "SELECT f FROM Fichas f WHERE f.stateId = :stateId"),
    @NamedQuery(name = "Fichas.findByFoto", query = "SELECT f FROM Fichas f WHERE f.foto = :foto")})
public class Fichas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkficha")
    private Integer pkficha;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "mote")
    private String mote;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "state_id")
    private int stateId;
    @Basic(optional = false)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkficha")
    private List<Transacciones> transaccionesList;

    public Fichas() {
    }

    public Fichas(Integer pkficha) {
        this.pkficha = pkficha;
    }

    public Fichas(Integer pkficha, String nombre, String mote, int telefono, int stateId, String foto) {
        this.pkficha = pkficha;
        this.nombre = nombre;
        this.mote = mote;
        this.telefono = telefono;
        this.stateId = stateId;
        this.foto = foto;
    }

    public Integer getPkficha() {
        return pkficha;
    }

    public void setPkficha(Integer pkficha) {
        this.pkficha = pkficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
        hash += (pkficha != null ? pkficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichas)) {
            return false;
        }
        Fichas other = (Fichas) object;
        if ((this.pkficha == null && other.pkficha != null) || (this.pkficha != null && !this.pkficha.equals(other.pkficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pojos.Fichas[ pkficha=" + pkficha + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t"),
    @NamedQuery(name = "Transacciones.findByPktransaccion", query = "SELECT t FROM Transacciones t WHERE t.pktransaccion = :pktransaccion"),
    @NamedQuery(name = "Transacciones.findByCantidad", query = "SELECT t FROM Transacciones t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "Transacciones.findByPersonaAnade", query = "SELECT t FROM Transacciones t WHERE t.personaAnade = :personaAnade"),
    @NamedQuery(name = "Transacciones.findByFecha", query = "SELECT t FROM Transacciones t WHERE t.fecha = :fecha")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pktransaccion")
    private Integer pktransaccion;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "persona_anade")
    private String personaAnade;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "fkficha", referencedColumnName = "pkficha")
    @ManyToOne(optional = false)
    private Fichas fkficha;
    @JoinColumn(name = "fkitem", referencedColumnName = "pkitem")
    @ManyToOne(optional = false)
    private Items fkitem;

    public Transacciones() {
    }

    public Transacciones(Integer pktransaccion) {
        this.pktransaccion = pktransaccion;
    }

    public Transacciones(Integer pktransaccion, int cantidad, String personaAnade) {
        this.pktransaccion = pktransaccion;
        this.cantidad = cantidad;
        this.personaAnade = personaAnade;
    }

    public Integer getPktransaccion() {
        return pktransaccion;
    }

    public void setPktransaccion(Integer pktransaccion) {
        this.pktransaccion = pktransaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPersonaAnade() {
        return personaAnade;
    }

    public void setPersonaAnade(String personaAnade) {
        this.personaAnade = personaAnade;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Fichas getFkficha() {
        return fkficha;
    }

    public void setFkficha(Fichas fkficha) {
        this.fkficha = fkficha;
    }

    public Items getFkitem() {
        return fkitem;
    }

    public void setFkitem(Items fkitem) {
        this.fkitem = fkitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pktransaccion != null ? pktransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.pktransaccion == null && other.pktransaccion != null) || (this.pktransaccion != null && !this.pktransaccion.equals(other.pktransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pojos.Transacciones[ pktransaccion=" + pktransaccion + " ]";
    }
    
}

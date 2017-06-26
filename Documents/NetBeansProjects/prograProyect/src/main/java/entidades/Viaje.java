/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VJ
 */
@Entity
@Table(catalog = "proyectofinal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
    , @NamedQuery(name = "Viaje.findByCodViaje", query = "SELECT v FROM Viaje v WHERE v.codViaje = :codViaje")
    , @NamedQuery(name = "Viaje.findByPrecio", query = "SELECT v FROM Viaje v WHERE v.precio = :precio")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codViaje;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double precio;
    @JoinColumn(name = "codDestino", referencedColumnName = "codDestino", nullable = false)
    @ManyToOne(optional = false)
    private Destino codDestino;
    @JoinColumn(name = "codBus", referencedColumnName = "codBus", nullable = false)
    @ManyToOne(optional = false)
    private Bus codBus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codViaje")
    private Collection<Reserva> reservaCollection;

    public Viaje() {
    }

    public Viaje(Integer codViaje) {
        this.codViaje = codViaje;
    }

    public Viaje(Integer codViaje, double precio) {
        this.codViaje = codViaje;
        this.precio = precio;
    }

    public Integer getCodViaje() {
        return codViaje;
    }

    public void setCodViaje(Integer codViaje) {
        this.codViaje = codViaje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Destino getCodDestino() {
        return codDestino;
    }

    public void setCodDestino(Destino codDestino) {
        this.codDestino = codDestino;
    }

    public Bus getCodBus() {
        return codBus;
    }

    public void setCodBus(Bus codBus) {
        this.codBus = codBus;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codViaje != null ? codViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.codViaje == null && other.codViaje != null) || (this.codViaje != null && !this.codViaje.equals(other.codViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Viaje[ codViaje=" + codViaje + " ]";
    }
    
}

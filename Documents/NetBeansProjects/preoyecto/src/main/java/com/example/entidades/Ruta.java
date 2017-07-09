/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entidades;

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
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByCodRuta", query = "SELECT r FROM Ruta r WHERE r.codRuta = :codRuta")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codRuta;
    @JoinColumn(name = "origenRuta", referencedColumnName = "codCiudad", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad origenRuta;
    @JoinColumn(name = "destinoRuta", referencedColumnName = "codCiudad", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad destinoRuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codRuta")
    private Collection<Destino> destinoCollection;

    public Ruta() {
    }

    public Ruta(Integer codRuta) {
        this.codRuta = codRuta;
    }

    public Integer getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(Integer codRuta) {
        this.codRuta = codRuta;
    }

    public Ciudad getOrigenRuta() {
        return origenRuta;
    }

    public void setOrigenRuta(Ciudad origenRuta) {
        this.origenRuta = origenRuta;
    }

    public Ciudad getDestinoRuta() {
        return destinoRuta;
    }

    public void setDestinoRuta(Ciudad destinoRuta) {
        this.destinoRuta = destinoRuta;
    }

    @XmlTransient
    public Collection<Destino> getDestinoCollection() {
        return destinoCollection;
    }

    public void setDestinoCollection(Collection<Destino> destinoCollection) {
        this.destinoCollection = destinoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRuta != null ? codRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.codRuta == null && other.codRuta != null) || (this.codRuta != null && !this.codRuta.equals(other.codRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entidades.Ruta[ codRuta=" + codRuta + " ]";
    }
    
}

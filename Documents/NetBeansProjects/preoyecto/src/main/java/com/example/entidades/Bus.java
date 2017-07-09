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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b")
    , @NamedQuery(name = "Bus.findByCodBus", query = "SELECT b FROM Bus b WHERE b.codBus = :codBus")
    , @NamedQuery(name = "Bus.findByCapacidadBus", query = "SELECT b FROM Bus b WHERE b.capacidadBus = :capacidadBus")
    , @NamedQuery(name = "Bus.findByMarcaBus", query = "SELECT b FROM Bus b WHERE b.marcaBus = :marcaBus")
    , @NamedQuery(name = "Bus.findByNumBus", query = "SELECT b FROM Bus b WHERE b.numBus = :numBus")
    , @NamedQuery(name = "Bus.findByPlacaBus", query = "SELECT b FROM Bus b WHERE b.placaBus = :placaBus")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codBus;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int capacidadBus;
    @Size(max = 55)
    @Column(length = 55)
    private String marcaBus;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int numBus;
    @Size(max = 55)
    @Column(length = 55)
    private String placaBus;
    @JoinColumn(name = "codEmpresa", referencedColumnName = "codEmpresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa codEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codBus")
    private Collection<Viaje> viajeCollection;

    public Bus() {
    }

    public Bus(Integer codBus) {
        this.codBus = codBus;
    }

    public Bus(Integer codBus, int capacidadBus, int numBus) {
        this.codBus = codBus;
        this.capacidadBus = capacidadBus;
        this.numBus = numBus;
    }

    public Integer getCodBus() {
        return codBus;
    }

    public void setCodBus(Integer codBus) {
        this.codBus = codBus;
    }

    public int getCapacidadBus() {
        return capacidadBus;
    }

    public void setCapacidadBus(int capacidadBus) {
        this.capacidadBus = capacidadBus;
    }

    public String getMarcaBus() {
        return marcaBus;
    }

    public void setMarcaBus(String marcaBus) {
        this.marcaBus = marcaBus;
    }

    public int getNumBus() {
        return numBus;
    }

    public void setNumBus(int numBus) {
        this.numBus = numBus;
    }

    public String getPlacaBus() {
        return placaBus;
    }

    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @XmlTransient
    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBus != null ? codBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.codBus == null && other.codBus != null) || (this.codBus != null && !this.codBus.equals(other.codBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entidades.Bus[ codBus=" + codBus + " ]";
    }
    
}

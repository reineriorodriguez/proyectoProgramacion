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
    @NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d")
    , @NamedQuery(name = "Destino.findByCodDestino", query = "SELECT d FROM Destino d WHERE d.codDestino = :codDestino")})
public class Destino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDestino")
    private Collection<Viaje> viajeCollection;
    @JoinColumn(name = "codRuta", referencedColumnName = "codRuta", nullable = false)
    @ManyToOne(optional = false)
    private Ruta codRuta;
    @JoinColumn(name = "codHorario", referencedColumnName = "codHorario", nullable = false)
    @ManyToOne(optional = false)
    private Horario codHorario;

    public Destino() {
    }

    public Destino(Integer codDestino) {
        this.codDestino = codDestino;
    }

    public Integer getCodDestino() {
        return codDestino;
    }

    public void setCodDestino(Integer codDestino) {
        this.codDestino = codDestino;
    }

    @XmlTransient
    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    public Ruta getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(Ruta codRuta) {
        this.codRuta = codRuta;
    }

    public Horario getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(Horario codHorario) {
        this.codHorario = codHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDestino != null ? codDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destino)) {
            return false;
        }
        Destino other = (Destino) object;
        if ((this.codDestino == null && other.codDestino != null) || (this.codDestino != null && !this.codDestino.equals(other.codDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entidades.Destino[ codDestino=" + codDestino + " ]";
    }
    
}

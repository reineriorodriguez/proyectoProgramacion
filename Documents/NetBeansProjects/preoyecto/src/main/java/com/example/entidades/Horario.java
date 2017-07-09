/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByCodHorario", query = "SELECT h FROM Horario h WHERE h.codHorario = :codHorario")
    , @NamedQuery(name = "Horario.findByHoraSalida", query = "SELECT h FROM Horario h WHERE h.horaSalida = :horaSalida")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codHorario;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codHorario")
    private Collection<Destino> destinoCollection;

    public Horario() {
    }

    public Horario(Integer codHorario) {
        this.codHorario = codHorario;
    }

    public Horario(Integer codHorario, Date horaSalida) {
        this.codHorario = codHorario;
        this.horaSalida = horaSalida;
    }

    public Integer getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(Integer codHorario) {
        this.codHorario = codHorario;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
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
        hash += (codHorario != null ? codHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.codHorario == null && other.codHorario != null) || (this.codHorario != null && !this.codHorario.equals(other.codHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entidades.Horario[ codHorario=" + codHorario + " ]";
    }
    
}

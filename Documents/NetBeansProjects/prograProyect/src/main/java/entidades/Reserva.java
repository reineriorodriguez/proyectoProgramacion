/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VJ
 */
@Entity
@Table(catalog = "proyectofinal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByCodReserva", query = "SELECT r FROM Reserva r WHERE r.codReserva = :codReserva")
    , @NamedQuery(name = "Reserva.findByFechaReserva", query = "SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva")
    , @NamedQuery(name = "Reserva.findByFechaSalida", query = "SELECT r FROM Reserva r WHERE r.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Reserva.findByNumAsientosReserva", query = "SELECT r FROM Reserva r WHERE r.numAsientosReserva = :numAsientosReserva")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codReserva;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int numAsientosReserva;
    @JoinColumn(name = "codViaje", referencedColumnName = "codViaje", nullable = false)
    @ManyToOne(optional = false)
    private Viaje codViaje;
    @JoinColumn(name = "codUsuario", referencedColumnName = "codUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario codUsuario;

    public Reserva() {
    }

    public Reserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public Reserva(Integer codReserva, Date fechaReserva, Date fechaSalida, int numAsientosReserva) {
        this.codReserva = codReserva;
        this.fechaReserva = fechaReserva;
        this.fechaSalida = fechaSalida;
        this.numAsientosReserva = numAsientosReserva;
    }

    public Integer getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumAsientosReserva() {
        return numAsientosReserva;
    }

    public void setNumAsientosReserva(int numAsientosReserva) {
        this.numAsientosReserva = numAsientosReserva;
    }

    public Viaje getCodViaje() {
        return codViaje;
    }

    public void setCodViaje(Viaje codViaje) {
        this.codViaje = codViaje;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReserva != null ? codReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codReserva == null && other.codReserva != null) || (this.codReserva != null && !this.codReserva.equals(other.codReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reserva[ codReserva=" + codReserva + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VJ
 */
@Entity
@Table(catalog = "proyectofinal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodUsuario", query = "SELECT u FROM Usuario u WHERE u.codUsuario = :codUsuario")
    , @NamedQuery(name = "Usuario.findByPwdUsuario", query = "SELECT u FROM Usuario u WHERE u.pwdUsuario = :pwdUsuario")
    , @NamedQuery(name = "Usuario.findByUsrUsuario", query = "SELECT u FROM Usuario u WHERE u.usrUsuario = :usrUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String pwdUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String usrUsuario;
    @JoinColumn(name = "tipoUsr", referencedColumnName = "codTipo", nullable = false)
    @ManyToOne(optional = false)
    private Tipousuario tipoUsr;

    public Usuario() {
    }

    public Usuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(Integer codUsuario, String pwdUsuario, String usrUsuario) {
        this.codUsuario = codUsuario;
        this.pwdUsuario = pwdUsuario;
        this.usrUsuario = usrUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    public String getUsrUsuario() {
        return usrUsuario;
    }

    public void setUsrUsuario(String usrUsuario) {
        this.usrUsuario = usrUsuario;
    }

    public Tipousuario getTipoUsr() {
        return tipoUsr;
    }

    public void setTipoUsr(Tipousuario tipoUsr) {
        this.tipoUsr = tipoUsr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entidades.Usuario[ codUsuario=" + codUsuario + " ]";
    }
    
}

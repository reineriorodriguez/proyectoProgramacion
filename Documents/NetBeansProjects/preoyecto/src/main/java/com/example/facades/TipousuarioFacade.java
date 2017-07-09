/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.facades;

import com.example.entidades.Tipousuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author VJ
 */
@Stateless
public class TipousuarioFacade extends AbstractFacade<Tipousuario> {

    @PersistenceContext(unitName = "com.example_preoyecto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipousuarioFacade() {
        super(Tipousuario.class);
    }
    
}

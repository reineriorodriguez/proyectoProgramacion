/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.facades;

import com.example.entidades.Destino;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author VJ
 */
@Stateless
public class DestinoFacade extends AbstractFacade<Destino> {

    @PersistenceContext(unitName = "com.example_preoyecto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DestinoFacade() {
        super(Destino.class);
    }
    
}

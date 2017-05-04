/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.human.ecg;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco Macedo
 */
@Stateless
public class EcgFacade extends AbstractFacade<Ecg> {

    @PersistenceContext(unitName = "com.human_ECG_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EcgFacade() {
        super(Ecg.class);
    }
    
}

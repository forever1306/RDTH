/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Distributor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Minh-IT
 */
public class DistributorModel extends ManagerBase<Distributor>{

    @Override
    public List<Distributor> find(Object keyword, String column, boolean like) {
        return super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Distributor getByID(Serializable id) {
        return super.getByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(Distributor entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Distributor entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Distributor> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<Distributor> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OderDetail;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Minh-IT
 */
public class OrderDetailModel extends ManagerBase<OderDetail>{

    @Override
    public List<OderDetail> find(Object keyword, String column, boolean like) {
        return super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OderDetail getByID(Serializable id) {
        return super.getByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(OderDetail entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(OderDetail entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OderDetail> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<OderDetail> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Feedback;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Minh-IT
 */
public class FeedbackModel extends ManagerBase<Feedback>{

    @Override
    public List<Feedback> find(Object keyword, String column, boolean like) {
        return super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Feedback getByID(Serializable id) {
        return super.getByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(Feedback entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Feedback entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Feedback> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<Feedback> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

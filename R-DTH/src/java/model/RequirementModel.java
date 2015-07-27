/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Requirement;
import entity.RequirementId;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Minh-IT
 */
public class RequirementModel extends ManagerBase<Requirement>{

    @Override
    public List<Requirement> find(Object keyword, String column, boolean like) {
        return super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Requirement getByID(Serializable id) {
        return super.getByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(Requirement entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Requirement entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Requirement> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<Requirement> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean updateSerial(RequirementId id,String newSerial){
        try{
            beginTranstion();
            Query query= session.createQuery("update Requirement set serial='"+newSerial+"' where productID='"+id.getProductId()+"' and customerID='"+id.getCustomerId()+"' and serial='"+id.getSerial()+"'");
            int rs= query.executeUpdate();
            comit();
            return rs>0;
        }catch(Exception ex){
            ex.printStackTrace();
            rollBack();
            return false;
        }
        finally{
            close();
        }
    }
    
}

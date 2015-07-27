/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.jdbc.object.SqlQuery;

/**
 *
 * @author Minh-IT
 */
public class OrderModel extends ManagerBase<Order> {

    @Override
    public List<Order> find(Object keyword, String column, boolean like) {
        return super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getByID(Serializable id) {
        return super.getByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(Order entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Order entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<Order> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getOrderIDByCustomer(String customerId) {
        int orderID = 0;
        try {
            beginTranstion();
            SQLQuery query = getCurrentSession().createSQLQuery("select oderID from [Order] where oderID=(select MAX(oderID) from [Order] where customerID='" + customerId + "' and status=1)");
            orderID = Integer.parseInt(query.uniqueResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return orderID;
    }
    public int getOrderIDByCustomerNonActive(String customerId) {
        int orderID = 0;
        try {
            beginTranstion();
            SQLQuery query = getCurrentSession().createSQLQuery("select oderID from [Order] where oderID=(select MAX(oderID) from [Order] where customerID='" + customerId + "')");
            orderID = Integer.parseInt(query.uniqueResult().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return orderID;
    }
    
    public void evict(Object ojb){
        getCurrentSession().evict(ojb);
    }

}

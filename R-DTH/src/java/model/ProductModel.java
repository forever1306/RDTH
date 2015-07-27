/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Minh-IT
 */
public class ProductModel extends ManagerBase<Product> {

    @Override
    public List<Product> find(Object keyword, String column, boolean like) {
        return super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getByID(Serializable id) {
        return super.getByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(Product entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Product entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<Product> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

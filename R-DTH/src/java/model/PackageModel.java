/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Chanel;
import entity.Packages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Minh-IT
 */
public class PackageModel extends ManagerBase<Packages> {

    @Override
    public List<Packages> find(Object keyword, String column, boolean like) {
        List<Packages> listPackage = super.find(keyword, column, like); //To change body of generated methods, choose Tools | Templates.

        return getTypeAndPrice(listPackage);
    }

    private List<Packages> getTypeAndPrice(List<Packages> list) {
        for (Packages pack : list) {
            Set<Chanel> listChanel = pack.getChanels();
            byte type = 0;
            double price = 0;
            for (Chanel cl : listChanel) {
                price += cl.getChanelPrice();
                if (type < cl.getType()) {
                    type = cl.getType();
                }
                pack.setPackagePrice(price);
                pack.setType(type);
            }
        }
        return list;
    }

    @Override
    public Packages getByID(Serializable id) {
        Packages pack = super.getByID(id); //To change body of generated methods, choose Tools | Templates.
        if (pack != null) {
            Set<Chanel> listChanel = pack.getChanels();
            byte type = 0;
            double price = 0;
            for (Chanel cl : listChanel) {
                price += cl.getChanelPrice();
                if (type < cl.getType()) {
                    type = cl.getType();
                }
                pack.setPackagePrice(price);
                pack.setType(type);
            }
        }
        return pack;
    }

    @Override
    public boolean addOrUpdate(Packages entity) {
        return super.addOrUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Packages entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Packages> getAll() {
        List<Packages> list = super.getAll(); //To change body of generated methods, choose Tools | Templates.
        return getTypeAndPrice(list);
    }

    @Override
    public Class<Packages> getPersistenClass() {
        return super.getPersistenClass(); //To change body of generated methods, choose Tools | Templates.
    }

}

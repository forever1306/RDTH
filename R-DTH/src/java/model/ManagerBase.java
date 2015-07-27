/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Minh-IT
 */
public abstract class ManagerBase<T> extends HibernateUtil {

    private Class<T> persistenClass;

    public Class<T> getPersistenClass() {
        return persistenClass;
    }

    public ManagerBase() {
        persistenClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<T> getAll() {
        List<T> list = null;
        try {
            beginTranstion();
            list = getCurrentSession().createCriteria(persistenClass).list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return list;
    }

    public boolean delete(T entity) {
        try {
            beginTranstion();
            getCurrentSession().delete(entity);
            comit();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollBack();
        } finally {
            close();
        }
        return true;
    }

    public boolean addOrUpdate(T entity) {
        try {
            beginTranstion();
            getCurrentSession().saveOrUpdate(entity);
            comit();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollBack();
        } finally {
            close();
        }
        return true;
    }

    public T getByID(Serializable id) {
        T entity = null;
        try {
            beginTranstion();
            entity = (T) getCurrentSession().get(persistenClass, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return entity;
    }

    public List<T> find(Object keyword, String column, boolean like) {
        List<T> list = null;
        try {
            beginTranstion();
            criteria = getCrieria(persistenClass);
            if (like) {
                criteria.add(Restrictions.like(column, "%" + keyword + "%"));
            } else {
                criteria.add(Restrictions.eq(column, keyword));
            }
            list = criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return list;
    }
}

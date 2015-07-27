/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Minh-IT
 */
public class HibernateUtil {

    protected SessionFactory sessionFactory;
    protected Session session;
    protected Criteria criteria;

    public HibernateUtil() {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Session getCurrentSession() {
        return session;
    }

    protected void rollBack() {
        session.getTransaction().rollback();
    }

    protected void beginTranstion() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
    }

    protected Criteria getCrieria(Class cl) {
        return session.createCriteria(cl);
    }

    protected void comit() {
        try {
            session.getTransaction().commit();;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void close() {
        try {
            if (session.isOpen()) {
                session.clear();
                session.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

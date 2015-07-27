/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customer;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Minh-IT
 */
public class AdminModel {
    private final SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
    
    public List<Customer> getCustomers(){
        Session session=sessionFactory.getCurrentSession();
        try{    
            session.beginTransaction();
            List<Customer> listCustomer=session.createCriteria(Customer.class).list();
            return listCustomer;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally{
            session.close();
        }
    }
    
    public List<Customer> findCustomer(Customer customer){
        Session session=sessionFactory.getCurrentSession();
        try{    
            session.beginTransaction();
            Criteria cri=session.createCriteria(Customer.class);
            if(customer.getCusName()!=null){
                cri.add(Restrictions.like("cusName", "%"+customer.getCusName()+"%"));
            }
            if(customer.getCustomerId()!=null){
                cri.add(Restrictions.like("customerID", "%"+customer.getCustomerId()+"%"));
            }
            if(customer.getBankCardNumber()!=null){
                cri.add(Restrictions.eq("bankCardNumber", customer.getBankCardNumber()));
            }
            session.close();
            return cri.list();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }
    
    public boolean deleteCustomer(String id){
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            Customer customer =(Customer)session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean updateOrAddCustomer(Customer customer){
        Session session=sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}

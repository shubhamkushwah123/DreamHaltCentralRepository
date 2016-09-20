package com.dh.dao.implementations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;
import com.dh.dao.interfaces.LoginDaoInterface;

public class LoginDaoImpl implements LoginDaoInterface {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public Login retirevePassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public long verifyLogin(Login login) {
		Session session = sessionFactory.openSession();
		long userId = 0;
	    try {
	            session.beginTransaction();
	            String hql = "Select log.userId from Login log where log.username=:username and log.password=:password";      
	            System.out.println(hql);
	            Query query = session.createQuery(hql);
	            query.setParameter("username", login.getUsername());
	            query.setParameter("password", login.getPassword());
	            List result = query.list();
	            System.out.println("resultset:"+result);
	            Iterator iterator = result.iterator();
	            while(iterator.hasNext()){
	             userId  = (Long) iterator.next();
	                }
	           // User user = (User) session.get(User.class, userId);
	           // user.getListOfVerification();
	           
	    } catch (HibernateException e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	        }
	    } finally {
	        session.close();
	    }
		return userId;
	    
	}


	

	

}

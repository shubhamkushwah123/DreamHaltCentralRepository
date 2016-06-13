package com.dh.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dh.dao.entities.Test;

public class HibernateTest {
	
	public static void main(String args[])
	{
		Test t = new Test();
		t.setUsername("shubham");
		t.setPassword("kushwah");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		
		session.close();
		
		
	}

}

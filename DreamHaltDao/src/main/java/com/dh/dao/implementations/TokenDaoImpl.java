package com.dh.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dh.dao.entities.Token;
import com.dh.dao.interfaces.TokenDaoInterface;

public class TokenDaoImpl implements TokenDaoInterface{

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public boolean insertToken(Token token) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.saveOrUpdate(token);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return false;	
		}

	}

}

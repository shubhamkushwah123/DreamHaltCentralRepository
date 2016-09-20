package com.dh.dao.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.ProfileImage;
import com.dh.dao.entities.User;
import com.dh.dao.entities.Verification;
import com.dh.dao.interfaces.ManageUserDaoInterface;

public class ManageUserDaoImpl implements ManageUserDaoInterface {

	@SuppressWarnings("deprecation")
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	 
	public long createUser(User user,Login login) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		long userId= (Long) session.save(user);
		login.setUserId(userId);
		session.save(login);
		session.getTransaction().commit();
		session.close();
		return userId;
		}catch(Exception e)
		{
			session.close();
			return 0l;	
		}
		
		
	}

	 
	public User updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.update(user);
		session.getTransaction().commit();
		session.close();
		return user;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;
		}
	}

	

	 
	public User retrieveUser(long userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	

	 
	public Verification addVerification(Verification verification) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.save(verification);
		session.getTransaction().commit();
		session.close();
		return verification;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;	
		}
	}

	 
	public boolean removeVerification(Verification verification) {
		// TODO Auto-generated method stub
		return false;
	}

	 
	public Verification updateVerification(Verification verification) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.update(verification);
		session.getTransaction().commit();
		session.close();
		return verification;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;
		}
	}

	 
	public List<Verification> getAllVerification(long userId) {
		List<Verification> list = new ArrayList<Verification>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		User user = (User) session.get(User.class, userId);
		//list = user.getListOfVerification();
		session.close();
		return list;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;
		}
	}
	
	
	 
	public Verification getVerification(long verificationId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		Verification verification = (Verification) session.get(Verification.class, verificationId);
		session.close();
		return verification;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;
			
		}
	}

	 
	public Address addAddress(Address address) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.save(address);
		System.out.println(address.getAddressId());
		session.getTransaction().commit();
		session.close();
		return address;
		}catch(Exception e)
		{
			session.close();
			System.out.println("EXCEPTION OCCURED");
			return null;
		}
		
	}

	 
	public Address removeAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	public Address updateAddress(Address address) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
			session.update(address);
			session.getTransaction().commit();
			session.close();
			return address;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;	
		}
		
	}

	 
	public Address getAddress(long addressId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
			Address address = (Address) session.get(Address.class, addressId);
			session.close();
			return address;
		}catch(Exception e)
		{
			e.printStackTrace();
			session.close();
			return null;
		}
	}

	 
	public ProfileImage addProfileImage(ProfileImage profileImage) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.save(profileImage);
		System.out.println(profileImage.getImageId());
		session.getTransaction().commit();
		session.close();
		return profileImage;
		}catch(Exception e)
		{
			session.close();
			System.out.println("EXCEPTION OCCURED");
			return null;
		}
	}

	
	 
	public ProfileImage updateProfileImage(ProfileImage profileImage) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		session.update(profileImage);
		session.getTransaction().commit();
		session.close();
		return profileImage;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;
		}
	}

	 
	public ProfileImage getProfileImage(long userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try{
		User user = (User) session.get(User.class, userId);
		ProfileImage image = user.getImage();
		session.close();
		return image;
		}catch(Exception e)
		{
			session.close();
			e.printStackTrace();
			return null;
		}
	}

	 
	public ProfileImage removeProfileImage(ProfileImage profileImage) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	 
	public boolean verifyLogin(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	 
	public boolean retrieveLogin(String username) {
		Session session = sessionFactory.openSession();
		long userId = 0;
	    try {
	            session.beginTransaction();
	            String hql = "Select log.userId from Login log where log.username=:username";      
	            System.out.println(hql);
	            Query query = session.createQuery(hql);
	            query.setParameter("username", username);
	            List result = query.list();
	            System.out.println("resultset:"+result);
	            Iterator iterator = result.iterator();
	            while(iterator.hasNext()){
	               return true;
	                }
	           
	    } catch (HibernateException e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	        }
	    } finally {
	        session.close();
	    }
	    return false;
	}
	
}

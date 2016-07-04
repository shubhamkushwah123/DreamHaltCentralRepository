package com.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dh.dao.entities.Address;
import com.dh.dao.entities.ProfileImage;
import com.dh.dao.entities.User;
import com.dh.dao.entities.Verification;


public class HelloWorld {
	
	public static void main(String args[])
	{
		//Test user = new Test("shubham","kushwah",true,"shubhamkushwah123@gmail.com","9826433237","shubham","I am Engg.","TCS");
	
		User user = new User();
		user.setFirstName("shubham");
		user.setLastName("kushwah");
		user.setDescription("I am a tom boy");
		user.setDob(new Date());
		user.setGender("Male");
		user.setEmail("shubham@gmail.com");
		user.setMobileNo("9004050499");
		user.setLandLineNo("7342533050");
		user.setSchool("Study Home School");
		user.setCollege("GECU");
		user.setOrganisation("TCS");
		user.setCreatedAt(new Date());
		user.setLastUpdatedAt(new Date());
		user.setStatus('A');
		
		
		Address address = new Address();
		address.setType('P');
		address.setHouseNo("69-B");
		address.setStreet("Dummy");
		address.setColony("Vidhyapati Nagar");
		address.setArea("Nanakheda");
		address.setLandmark("Near Maharaja Dhabha");
		address.setPincode("456010");
		address.setCity("Ujjain");
		address.setState("MP");
		address.setCountry("INDIA");
		
		user.setAddress(address);
		
		ProfileImage image = new ProfileImage();
		image.setImageType('P');
		image.setName("My Profile Image name");
		image.setStatus('V');
		image.setCreatedAt(new Date());
		image.setUpdatedAt(new Date());
		user.setImage(image);
		
		
		
		Verification v1 = new Verification();
		v1.setvType("Passport");
		v1.setvAttachment("Passport Image");
		
		
		Verification v2 = new Verification();
		v2.setvType("Pancard");
		v2.setvAttachment("Pancard Image");
		
		user.getListOfVerification().add(v1);
		user.getListOfVerification().add(v2);
		v1.setUser(user);
		v2.setUser(user);
		
		
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		
		session.save(user);
		session.save(v1);
		session.save(v2);
		session.save(address);
		session.save(image);
		
		
		
		session.getTransaction().commit();
		
		session.close();
	}

}

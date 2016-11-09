package com.test.Service;

import java.util.Date;

import com.dh.business.service.implementation.ManageUserServiceImpl;
import com.dh.business.service.interfaces.ManageUserServiceInterface;
import com.dh.dao.entities.Address;
import com.dh.dao.entities.Login;
import com.dh.dao.entities.User;

public class generateTestData {
	
	
	public static void main(String args[]) throws Exception
	{
		ManageUserServiceInterface userService = new ManageUserServiceImpl();
		User user = getUser();
		Login login = new Login();
		login.setUsername(user.getEmail());
		login.setPassword(user.getPassword());
		if(userService.registerUser(user,login))
		{
			System.out.println("Registration is successful, An email is sent to your email address, please verify");
		}
		else{
			System.out.println("User already exist");
		}
		
	}
	
	public static  User getUser() {
		User user = new User();
		user.setFirstName("shubham");
		user.setLastName("kushwah");
		user.setDescription("I am a tom boy");
		user.setDob(new Date());
		user.setGender("Male");
		user.setEmail("shubhamkushwah123@gmail.com");
		user.setMobileNo("9004050499");
		user.setLandLineNo("7342533050");
		user.setSchool("Study Home School");
		user.setCollege("GECU");
		user.setOrganisation(null);
		user.setCreatedAt(new Date());
		user.setLastUpdatedAt(new Date());
		user.setStatus('A');
		user.setPassword("Shubham123");
		return user;
	}
	
	public Address getAddress() {
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
		return address;
	}
	
	

}
